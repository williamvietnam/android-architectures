package com.base.mvvm.core.data.network

import com.google.gson.annotations.SerializedName

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
open class BaseListResponse<D : BaseResponse>(

    @SerializedName("content")
    var dataResponse: List<D>?,

    @SerializedName("current_page")
    var currentPage: Int,

    @SerializedName("total_pages")
    var totalPages: Int,

    @SerializedName("size")
    var size: Int,

    @SerializedName("total_elements")
    var total_elements: Int

) : BaseResponse()