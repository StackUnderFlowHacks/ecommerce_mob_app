package com.mrwhoknows.ecommerce_mob_app.network.response


import com.mrwhoknows.ecommerce_mob_app.network.model.UserProfileDto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserLoginResponse(
    @Json(name = "access_token")
    val accessToken: String? = null,
    @Json(name = "csrf_token")
    val csrfToken: String? = null,
    @Json(name = "refresh_token")
    val refreshToken: String? = null,
    @Json(name = "status")
    val status: Boolean? = null,
    @Json(name = "user")
    val user: UserProfileDto? = null
)