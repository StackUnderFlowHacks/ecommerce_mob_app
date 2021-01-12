package com.mrwhoknows.ecommerce_mob_app.network.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserLogoutResponse(
    @Json(name = "response")
    val response: String? = null,
    @Json(name = "status")
    val status: Boolean? = null
)