package com.mrwhoknows.ecommerce_mob_app.domain.model


data class UserProfile(
    val dateJoined: String,
    val email: String,
    val id: Int,
    val phone: String,
    val username: String,
    val address: UserAddress?
)

data class UserAddress(
    val area: String,
    val landmark: String,
    val city: String,
    val country: String,
    val state: String,
    val pinCode: Int,
    val type: String
)

data class UserTokens(
    val access_token: String?,
    val refresh_token: String?,
    val csrf_token: String?
)