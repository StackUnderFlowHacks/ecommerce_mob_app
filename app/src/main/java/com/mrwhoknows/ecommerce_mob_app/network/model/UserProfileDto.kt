package com.mrwhoknows.ecommerce_mob_app.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserProfileDto(
    @Json(name = "date_joined")
    val dateJoined: String? = null,
    @Json(name = "email")
    val email: String? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "phone")
    val phone: String? = null,
    @Json(name = "username")
    val username: String? = null,
    @Json(name = "address")
    val address: UserAddressDto? = null
)

@JsonClass(generateAdapter = true)
data class UserAddressDto(
    @Json(name = "area")
    val area: String? = null,
    @Json(name = "city")
    val city: String? = null,
    @Json(name = "country")
    val country: String? = null,
    @Json(name = "landmark")
    val landmark: String? = null,
    @Json(name = "pinCode")
    val pinCode: String? = null,
    @Json(name = "state")
    val state: String? = null,
    @Json(name = "type")
    val type: String? = null
)