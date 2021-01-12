package com.mrwhoknows.ecommerce_mob_app.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserLoginDto(
    @Json(name = "email")
    val email: String? = null,
    @Json(name = "password")
    val password: String? = null
)