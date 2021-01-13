package com.mrwhoknows.ecommerce_mob_app.network.util

import com.mrwhoknows.ecommerce_mob_app.domain.model.UserProfile
import com.mrwhoknows.ecommerce_mob_app.domain.model.UserTokens
import com.mrwhoknows.ecommerce_mob_app.network.model.UserLoginDto
import com.mrwhoknows.ecommerce_mob_app.network.model.UserProfileDto
import com.mrwhoknows.ecommerce_mob_app.network.response.UserLoginResponse
import com.mrwhoknows.ecommerce_mob_app.util.DomainMapper

class UserDtoMapper : DomainMapper<UserProfileDto, UserProfile> {

    //    TODO separate the address mapping
    override fun mapToDomainModel(model: UserProfileDto): UserProfile {
        return UserProfile(
            dateJoined = model.dateJoined ?: "Not Available",
            email = model.email ?: "Not Available",
            phone = model.phone ?: "Not Available",
            id = model.id ?: -1,
            username = model.username ?: "Not Available",
            address = null
        )
    }

    override fun mapFromDomainModel(domainModel: UserProfile): UserProfileDto {
        return UserProfileDto(
            dateJoined = domainModel.dateJoined,
            email = domainModel.email,
            phone = domainModel.phone,
            id = domainModel.id,
            username = domainModel.username,
            address = null
        )
    }

    inner class UserTokenMapper : DomainMapper<UserLoginResponse, UserTokens> {

        override fun mapToDomainModel(model: UserLoginResponse): UserTokens {
            return UserTokens(
                access_token = model.accessToken,
                refresh_token = model.refreshToken,
                csrf_token = model.csrfToken
            )
        }

        override fun mapFromDomainModel(domainModel: UserTokens): UserLoginResponse {
            return UserLoginResponse()
        }
    }

    inner class UserLoginMapper : DomainMapper<UserLoginDto, Pair<String, String>> {
        override fun mapToDomainModel(model: UserLoginDto): Pair<String, String> {
            return Pair(
                model.email ?: "Error",
                model.password ?: "Error"
            )
        }

        override fun mapFromDomainModel(domainModel: Pair<String, String>): UserLoginDto {
            return UserLoginDto(
                domainModel.first,
                domainModel.second
            )
        }
    }
}


