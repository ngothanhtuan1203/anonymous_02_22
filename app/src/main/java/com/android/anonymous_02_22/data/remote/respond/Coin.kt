package com.android.anonymous_02_22.data.remote.respond

import com.google.gson.annotations.SerializedName

data class Coin (
    @SerializedName("base")
   val base :String?,

    @SerializedName("counter")
   val counter: String? = null,

    @SerializedName("buy_price")
   val buyPrice: String? = null,

    @SerializedName("sell_price")
   val sellPrice: String? = null,

    @SerializedName("icon")
   val icon: String? = null,

    @SerializedName("name")
   val name: String? = null
)