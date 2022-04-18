package com.android.anonymous_02_22.data.remote.respond

import com.google.gson.annotations.SerializedName

data class ModelSearch(
    @SerializedName("items")
    val modelSearchData: List<ModelSearchData>? = null
)