package com.base.mvvm.core.data.preferences

import javax.inject.Singleton

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
@Singleton
interface RxPreferences {
    fun put(key: String, value: String)

    fun get(key: String): String?

    fun clear()

    fun remove(key: String)

    fun getToken(): String?

    fun setUserToken(userToken: String)

    fun logout()

}