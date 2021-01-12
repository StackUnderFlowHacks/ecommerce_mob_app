package com.mrwhoknows.ecommerce_mob_app.network.service

import com.mrwhoknows.ecommerce_mob_app.network.model.UserLoginDto
import com.mrwhoknows.ecommerce_mob_app.network.response.UserLoginResponse
import com.mrwhoknows.ecommerce_mob_app.network.response.UserLogoutResponse
import com.mrwhoknows.ecommerce_mob_app.network.response.UserProfileResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface UserService {

    @POST("user/auth/login")
    suspend fun userLogin(
        @Body userLoginDto: UserLoginDto
    ): UserLoginResponse

    @POST("user/auth/logout")
    suspend fun userLogout(
        @Header("Authorization") authToken: String,
        @Header("X-CSRFToken") csrfToken: String
    ): UserLogoutResponse

    @GET("user/profile")
    suspend fun getUserProfile(
        @Header("Authorization") authToken: String,
        @Header("X-CSRFToken") csrfToken: String
    ): UserProfileResponse


    //    TODO Later
    @GET("user/orders")
    suspend fun getUserOrders(
        @Header("Authorization") authToken: String,
        @Header("X-CSRFToken") csrfToken: String
    )

}