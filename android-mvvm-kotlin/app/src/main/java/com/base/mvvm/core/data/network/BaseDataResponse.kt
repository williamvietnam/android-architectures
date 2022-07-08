package com.base.mvvm.core.data.network

import com.google.gson.annotations.SerializedName

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
class BaseDataResponse<D : BaseResponse>(
    @SerializedName("content")
    var dataResponse: D?,

    @SerializedName("success")
    var isSuccess: Boolean?,

    @SerializedName("warning")
    var isWarnings: Boolean?,

    @SerializedName("status")
    var status: Int?,

    @SerializedName("message")
    var message: String?
)