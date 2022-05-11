package com.android.anonymous_02_22.data.remote.respond.country
import com.google.gson.annotations.SerializedName

data class Data (

	@SerializedName("id") val id : Int,
	@SerializedName("type") val type : String,
	@SerializedName("make") val make : String,
	@SerializedName("model") val model : String,
	@SerializedName("carplate_number") val carplate_number : String,
	@SerializedName("price") val price : Double,
	@SerializedName("start_time") val start_time : Int,
	@SerializedName("end_time") val end_time : Int,
	@SerializedName("next_billing_date") val next_billing_date : Int,
	@SerializedName("mileage") val mileage : String,
	@SerializedName("total_outstanding_fine_count") val total_outstanding_fine_count : String,
	@SerializedName("total_outstanding_fine_amount") val total_outstanding_fine_amount : String,
	@SerializedName("earliest_payment_due_date") val earliest_payment_due_date : String,
	@SerializedName("total_per_km_rate") val total_per_km_rate : Double,
	@SerializedName("days_left") val days_left : String,
	@SerializedName("driven_this_month") val driven_this_month : Int,
	@SerializedName("usage_due_this_month") val usage_due_this_month : Int,
	@SerializedName("base_price") val base_price : String,
	@SerializedName("road_tax") val road_tax : Int,
	@SerializedName("insurance_excess") val insurance_excess : Int,
	@SerializedName("records") val records : List<Records>,
	@SerializedName("has_subscribed_insurance") val has_subscribed_insurance : Boolean,
	@SerializedName("help") val help : List<Help>,
	@SerializedName("updated_at") val updated_at : Int,
	@SerializedName("drivers") val drivers : List<Drivers>
)