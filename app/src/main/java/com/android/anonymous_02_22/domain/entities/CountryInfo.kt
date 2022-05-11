package com.android.anonymous_02_22.domain.entities

import com.google.gson.annotations.SerializedName

data class CountryInfo(
    @SerializedName("symbol") val symbol: String,
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: String
)