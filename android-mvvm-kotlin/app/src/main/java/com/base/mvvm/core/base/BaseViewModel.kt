package com.base.mvvm.core.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.base.mvvm.R
import com.base.mvvm.core.data.network.BaseResponse
import com.base.mvvm.core.data.network.ErrorResponse
import com.base.mvvm.core.utilities.SingleLiveEvent
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.net.ConnectException

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
abstract class BaseViewModel : ViewModel() {

    var messageError = SingleLiveEvent<Any>()
    var isLoading = MutableLiveData<Boolean>()

    fun handleError(
        throwable: Throwable,
        callBack: ((result: ErrorResponse) -> Unit?)?
    ) {
        if (throwable is ConnectException) {
            messageError.postValue(throwable.message)
        } else if (throwable is HttpException) {
            var errorBody: String? = null
            try {
                errorBody = throwable.response()!!.errorBody()!!.string()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            var response: ErrorResponse? = null
            try {
                response =
                    Gson().fromJson(
                        errorBody,
                        ErrorResponse::class.java
                    )
            } catch (e: Exception) {
                e.printStackTrace()
            }
            if (response != null) {
                if (response.status == 401) {
                    callBack?.invoke(response)
                } else {
                    messageError.postValue(
                        response.message ?: "${response.status} "
                    )
                }
            } else {
                messageError.postValue(throwable.message)
            }
        } else {
            messageError.postValue(R.string.not_connected_internet)
        }

    }

    inline fun <reified T : BaseResponse> handleError(
        responseBody: ResponseBody
    ): T? {
        var errorBody = ""
        try {
            errorBody = responseBody.string()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val typeResponse =
            object : TypeToken<T>() {}.type
        var response: T? = null
        try {
            response =
                Gson().fromJson(
                    errorBody,
                    T::class.java
                )
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return response

    }

}