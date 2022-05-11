package com.android.anonymous_02_22.data.remote.respond.country
import com.google.gson.annotations.SerializedName

data class Drivers (

	@SerializedName("name") val name : String,
	@SerializedName("phone") val phone : Int,
	@SerializedName("gender") val gender : String,
	@SerializedName("id_number") val id_number : String,
	@SerializedName("driver_type") val driver_type : String,
	@SerializedName("date_of_birth") val date_of_birth : Int,
	@SerializedName("marital_status") val marital_status : String,
	@SerializedName("driving_experience") val driving_experience : Int,
	@SerializedName("driving_license_number") val driving_license_number : String,
	@SerializedName("driving_license_registration_date") val driving_license_registration_date : Int
)