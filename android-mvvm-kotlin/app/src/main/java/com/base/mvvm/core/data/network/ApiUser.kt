package com.base.mvvm.core.data.network

import com.google.gson.annotations.SerializedName

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
data class ApiUser(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("email")
    val email: String = "",
    @SerializedName("avatar")
    val avatar: String = ""
)