package com.android.anonymous_02_22.data.remote.respond

import com.google.gson.annotations.SerializedName

data class CoinRespond(
    @SerializedName("data")
    val data: List<Coin>
)