package com.android.anonymous_02_22.data.remote.respond.country
import com.google.gson.annotations.SerializedName


data class CountryCarInfoRespond (
	@SerializedName("data") val data : Data,
	@SerializedName("success") val success : Success
)