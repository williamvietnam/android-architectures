package com.base.mvvm.core.data.network

import com.base.mvvm.core.utilities.Constants.NetworkRequestCode.REQUEST_CODE_400
import com.base.mvvm.core.utilities.Constants.NetworkRequestCode.REQUEST_CODE_401
import com.base.mvvm.core.utilities.Constants.NetworkRequestCode.REQUEST_CODE_403
import com.base.mvvm.core.utilities.Constants.NetworkRequestCode.REQUEST_CODE_404
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
class NetworkInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        when (response.code) {
            REQUEST_CODE_400, REQUEST_CODE_401, REQUEST_CODE_403, REQUEST_CODE_404 -> {
                Timber.d("network error code ${response.code}")
            }
        }
        return response
    }
}