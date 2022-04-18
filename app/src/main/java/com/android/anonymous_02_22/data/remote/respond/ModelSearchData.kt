package com.android.anonymous_02_22.data.remote.respond

import android.os.Parcel
import android.os.Parcelable.Creator
import com.google.gson.annotations.SerializedName

data class ModelSearchData(
    @SerializedName("login")
    val login: String? = null,

    @SerializedName("url")
    val url: String? = null,

    @SerializedName("avatar_url")
    val avatarUrl: String? = null,

    @SerializedName("html_url")
    val htmlUrl: String? = null
)