package com.base.mvvm.core.data.network

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
sealed class ViewState<T>(val data: T? = null) {

    class Loading<T>(data: T? = null) : ViewState<T>(data)

    class Error<T>(val throwable: Throwable, data: T? = null) : ViewState<T>(data)

    class Loaded<T>(data: T? = null) : ViewState<T>(data)


    fun isLoading(): Boolean = this is Loading
}