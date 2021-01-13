package com.mrwhoknows.ecommerce_mob_app.network.response


import com.mrwhoknows.ecommerce_mob_app.network.model.UserProfileDto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserProfileResponse(
    @Json(name = "status")
    val status: Boolean? = null,
    @Json(name = "user")
    val user: UserProfileDto? = null
)