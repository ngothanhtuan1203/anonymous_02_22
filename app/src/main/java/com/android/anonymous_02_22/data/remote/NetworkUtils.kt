package com.android.anonymous_02_22.data.remote

import android.content.Context
import android.util.Log
import com.android.anonymous_02_22.BuildConfig
import com.android.anonymous_02_22.data.local.AppPrefs
import com.google.gson.Gson
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.net.ssl.*

class NetworkUtils(
    private val context: Context,
    private val gson: Gson,
    private val appPref: AppPrefs
) {
    companion object {
        const val TIME_OUT = 60
    }

    private val TAG = NetworkUtils::class.simpleName

    private val cache = createOkHttpCache(context)

    fun isConnected(): Boolean = Connectivity().isConnectingToInternet(context)

    fun createRetrofit(): Retrofit {

        var skipSSL = false


        val loggingInterceptor = createLoggingInterceptor()
        val requestInterceptor = createRequestInterceptor()
        val client = createOkHttpClient(cache, loggingInterceptor, requestInterceptor)

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BuildConfig.SERVER_URL)
            .client(client)
            .build()
    }

    inline fun <reified T> createApiService(retrofit: Retrofit): T {
        return retrofit.create(T::class.java)
    }

    private fun createRequestInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()

            var token = BuildConfig.TOKEN
            val reqBuilder = request.newBuilder()


            var newRequest: Request? = null
            newRequest = reqBuilder
                .header("accept", "application/json")
                .header("Authorization", token ?: "")
                .method(request.method, request.body)
                .build()

            var respond = chain.proceed(newRequest)

            val respondCode = respond.code
            Log.d(TAG, "Retrofit http respond code:$respondCode ")
           val unauthorized = respondCode == 401
            respond
        }
    }

    private fun createLoggingInterceptor(): Interceptor {

        val logging = HttpLoggingInterceptor { message -> Log.d("Retrofit: ", message) }

        logging.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }

        return logging
    }

    private fun createOkHttpCache(context: Context): Cache {
        val size = (10 * 1024 * 1024).toLong() // 10 Mb
        return Cache(context.cacheDir, size)
    }

    private fun createOkHttpClient(
        cache: Cache,
        logging: Interceptor,
        request: Interceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()

        return builder
            .cache(cache)
            .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .addInterceptor(request)
            .addInterceptor(logging)
            .build()
    }
}
