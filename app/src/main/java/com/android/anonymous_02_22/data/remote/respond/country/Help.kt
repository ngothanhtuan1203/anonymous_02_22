package com.android.anonymous_02_22.data.remote.respond.country
import com.google.gson.annotations.SerializedName

data class Help (

	@SerializedName("key") val key : String,
	@SerializedName("label") val label : String,
	@SerializedName("value") val value : String
)