package com.base.mvvm.core.widget.extension

import java.text.SimpleDateFormat
import java.util.*

class DateParserFactory() {

    companion object {
        @Volatile
        private var INSTANCE: DateParserFactory? = null

        fun getInstance(): DateParserFactory =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: DateParserFactory().also { INSTANCE = it }
                }
    }

    val parserStandardFmt = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val parserSecond = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ", Locale.getDefault())
    val parserThird = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    val parserForth = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", Locale.getDefault())
    val parserFifth = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val parserSix = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val parserSeventh = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val parserSafe = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.getDefault())
    val apiResFromServer = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
    val lastUpdateServer = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
    val lastUpdateFormat = SimpleDateFormat("HH:mm dd/MM/yyyy ", Locale.getDefault())
    //val apiDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val serverDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val clientDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val standardDateTimeFmt = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS", Locale.getDefault())
    val apiDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val apiPostDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val uiDobInput = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val iso8601 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS", Locale.getDefault())
    val dateTimeSort = SimpleDateFormat("dd/MM", Locale.getDefault())
    val dateTimeFull = SimpleDateFormat("dd/MM, yyyy", Locale.getDefault())
}