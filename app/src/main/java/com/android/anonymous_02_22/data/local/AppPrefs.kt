package com.android.anonymous_02_22.data.local

import android.content.Context
import com.google.gson.Gson
import java.io.BufferedReader

class AppPrefs(private val gson: Gson, private val context: Context) {

    fun getData(): String {
        val fileName = "data.json"
        return context
            .assets
            .open(fileName)
            .bufferedReader()
            .use(BufferedReader::readText)
    }

    fun getCountries(): String {
        val fileName = "contries.json"
        return context
            .assets
            .open(fileName)
            .bufferedReader()
            .use(BufferedReader::readText)
    }
}