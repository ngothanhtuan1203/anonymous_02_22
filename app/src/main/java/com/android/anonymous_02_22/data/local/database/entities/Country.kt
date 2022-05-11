package com.android.anonymous_02_22.data.local.database.entities

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name") var name: String,
    @SerializedName("symbol") var symbol: String,
    @SerializedName("id") var id: String
)