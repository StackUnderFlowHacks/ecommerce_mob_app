package com.mrwhoknows.ecommerce_mob_app.repository

import com.mrwhoknows.ecommerce_mob_app.domain.model.UserProfile
import com.mrwhoknows.ecommerce_mob_app.domain.model.UserTokens

interface UserRepository {

    suspend fun userLogin(email: String, password: String): UserTokens?

    suspend fun userLogout(userTokens: UserTokens): Boolean

    suspend fun getUserProfile(userTokens: UserTokens): UserProfile?
}