package com.android.anonymous_02_22.domain.entities

import com.google.gson.annotations.SerializedName

data class GitProfile(
    @SerializedName("id")
    val id :Int?,
    @SerializedName("login")
    val login: String? = null,
    @SerializedName("avatar_url")
    val avatarUrl: String? = null,
    @SerializedName("html_url")
    val htmlUrl: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("blog")
    val blog: String? = null,
    @SerializedName("location")
    val location: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("bio")
    val bio: String? = null,
    @SerializedName("twitter_username")
    val twitterUsername: String? = null,
    @SerializedName("public_repos")
    val publicRepos: String? = null,
    @SerializedName("followers")
    val followers: String? = null,
    @SerializedName("following")
    val following: String? = null
)