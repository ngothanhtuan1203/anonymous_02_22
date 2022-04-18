package com.android.anonymous_02_22.domain.entities

import com.google.gson.annotations.SerializedName

data class FoundUser(

    @SerializedName("login")
    val login: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("avatar_url")
    val avatarUrl: String? = null,
    @SerializedName("html_url")
    val htmlUrl: String? = null
)