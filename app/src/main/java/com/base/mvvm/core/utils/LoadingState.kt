package com.base.mvvm.core.utils

/**
 * @author ThanhVV
 * @since 2020-02-19
 */
sealed class LoadingState {

    open class ERROR(val e: Throwable? = null) : LoadingState()

    object IDLE : LoadingState()

    object LOADING : LoadingState()

    object FINISH : LoadingState()
}