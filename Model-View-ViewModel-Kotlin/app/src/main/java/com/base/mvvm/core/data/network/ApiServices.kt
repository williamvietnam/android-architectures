package com.base.mvvm.core.data.network

import com.base.mvvm.core.data.network.models.ApiUser
import retrofit2.http.GET

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
interface ApiServices {
    @GET(ApiEndpoint.GET_USER_LIST)
    fun getUsers(): List<ApiUser>

    @GET(ApiEndpoint.GET_MORE_USERS)
    suspend fun getMoreUsers(): List<ApiUser>

    @GET(ApiEndpoint.GET_USERS_WITH_ERROR)
    suspend fun getUsersWithError(): List<ApiUser>
}
