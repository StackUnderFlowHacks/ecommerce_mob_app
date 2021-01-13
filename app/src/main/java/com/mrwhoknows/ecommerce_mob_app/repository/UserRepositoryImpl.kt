package com.mrwhoknows.ecommerce_mob_app.repository

import com.mrwhoknows.ecommerce_mob_app.domain.model.UserProfile
import com.mrwhoknows.ecommerce_mob_app.domain.model.UserTokens
import com.mrwhoknows.ecommerce_mob_app.network.service.UserService
import com.mrwhoknows.ecommerce_mob_app.network.util.UserDtoMapper

class UserRepositoryImpl(
    private val userService: UserService,
    private val userDtoMapper: UserDtoMapper,
) : UserRepository {

    override suspend fun userLogin(email: String, password: String): UserTokens? {
        val userCred = Pair(email, password)
        val result = userService.userLogin(
            userDtoMapper.UserLoginMapper().mapFromDomainModel(userCred)
        )
        //  Converts userLoginResponse into tokens and return
        return if (result.status!!)
            userDtoMapper.UserTokenMapper().mapToDomainModel(result)
        else null
    }

    override suspend fun userLogout(userTokens: UserTokens): Boolean {
        val result = userService.userLogout(
            userTokens.access_token!!,
            userTokens.csrf_token!!
        )
        return result.status!!
    }

    override suspend fun getUserProfile(userTokens: UserTokens): UserProfile? {
        val result = userService.getUserProfile(
            userTokens.access_token!!,
            userTokens.csrf_token!!
        )
        return if (result.status!!)
            userDtoMapper.mapToDomainModel(result.user!!)
        else
            null
    }
}