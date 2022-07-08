package com.base.mvvm.core.utilities

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
object Constants {
    const val PREF_FILE_NAME = "Preferences"
    const val DEFAULT_TIMEOUT = 30
    const val DURATION_TIME_CLICKABLE = 500L

    object NetworkRequestCode {
        const val REQUEST_CODE_200 = 200    //normal
        const val REQUEST_CODE_400 = 400    //parameter error
        const val REQUEST_CODE_401 = 401    //unauthorized error
        const val REQUEST_CODE_403 = 403
        const val REQUEST_CODE_404 = 404    //No data error
        const val REQUEST_CODE_500 = 500    //system error
    }

    object ApiComponents {
        const val BASE_URL = "https://google.com"
    }

}
