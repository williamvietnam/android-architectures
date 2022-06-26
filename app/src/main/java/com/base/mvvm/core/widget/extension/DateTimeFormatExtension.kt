package com.base.mvvm.core.widget.extension

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.DatePicker
import androidx.annotation.StringRes
import com.base.mvvm.R
import com.base.mvvm.core.utils.Constants
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


val dateFactory = DateParserFactory.getInstance()

fun String.dateFormatDisplay(
    context: Context,
    formatter: SimpleDateFormat = DateParserFactory.getInstance().clientDateFormat
): String {
    try {
        this.getDate()?.let {
            return formatter.format(it)
        }
    } catch (e: Exception) {
        Log.d(Constants.TAG_DATE_TIME_FORMAT_EXTENSION, "Datetime unable to format date display")
    }
    return this
}

fun String.getDate(): Date? {

    try {
        return dateFactory.parserStandardFmt.parse(this)
    } catch (e: ParseException) {
        Log.d(
            Constants.TAG_DATE_TIME_FORMAT_EXTENSION,
            "Datetime unable to parser parserStandardFmt date"
        )

        try {
            return dateFactory.parserSecond.parse(this)
        } catch (e: ParseException) {
            try {
                return dateFactory.parserThird.parse(this)
            } catch (e: ParseException) {
                try {
                    return dateFactory.parserForth.parse(this)
                } catch (e: ParseException) {
                    try {
                        return dateFactory.parserFifth.parse(this)
                    } catch (e: ParseException) {
                        return try {
                            dateFactory.parserSix.parse(this)
                        } catch (e: ParseException) {
                            try {
                                dateFactory.parserSafe.parse(this)
                            } catch (e: ParseException) {
                                try {
                                    dateFactory.parserSeventh.parse(this)
                                } catch (e: ParseException) {
                                    null
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun String.dateFormatByRes(context: Context, @StringRes resFmt: Int): String {
    return this.dateFormatDisplay(
        context,
        SimpleDateFormat(context.resources.getString(resFmt), Locale.getDefault())
    )
}

fun String.getMonth(context: Context): String {
    return this.dateFormatByRes(context, R.string.month_format)
}

fun String.getMonthYear(context: Context): String {
    return this.dateFormatByRes(context, R.string.month_year_format)
}

fun String.getDay(context: Context): String {
    return this.dateFormatByRes(context, R.string.day_format)
}

fun String.getDateTimeline(context: Context): String {
    return this.dateFormatByRes(
        context,
        R.string.day_time_line_format
    ) + " T" + this.dateFormatByRes(context, R.string.month_time_line_format)
}

fun String.getTimeIn24H(context: Context): String {
    return this.dateFormatByRes(context, R.string.time_format_24h)
}

fun String.getBothDateAndTime(context: Context): String {
    return this.dateFormatByRes(context, R.string.both_date_and_time_fmt)
}

fun Date.getAPIPostDateFormat(): String {
    return dateFactory.serverDateFormat.format(this)
}

fun String.getTimeRemain(): Long {
    this.getDate()?.let {
        val currentTime = Calendar.getInstance()
        currentTime.setToMidNight()

        val expectedDate = Calendar.getInstance()
        expectedDate.time = it
        expectedDate.setToMidNight()

        val diff = expectedDate.time.time - currentTime.time.time

        return when {
            diff > 0 -> {
                TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)
            }
            diff == 0L -> {
                0
            }
            else -> {
                -1
            }
        }
    }

    return 0
}

fun Date.toCalendarMidNight(): Long {
    val calendar = Calendar.getInstance()
    calendar.time = this
    calendar.setToMidNight()
    return calendar.timeInMillis
}

fun Calendar.setToMidNight() {
    set(Calendar.HOUR_OF_DAY, 0)
    set(Calendar.MINUTE, 0)
    set(Calendar.SECOND, 0)
    set(Calendar.MILLISECOND, 0)
}

fun Calendar.setToDayLight() {
    set(Calendar.HOUR_OF_DAY, 24)
    set(Calendar.MINUTE, 0)
    set(Calendar.SECOND, 0)
    set(Calendar.MILLISECOND, 0)
}

fun String.getPastTime(): Long {
    this.getDate()?.let {
        val currentTime = Calendar.getInstance()
        currentTime.setToDayLight()

        return getDiffInDay(currentTime.timeInMillis, it.time)
    }

    return 0
}

fun String.getFutureTime(): Long {
    this.getDate()?.let {
        val currentTime = Calendar.getInstance().time

        return getDiffInDay(it.time, currentTime.time)
    }

    return 0
}

private fun getDiffInDay(before: Long, after: Long): Long {
    val diff = before - after

    return if (diff > 0) {
        TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)
    } else {
        -1
    }
}

fun String.getDiffTimeBySecond(): Long {
    this.getDate()?.let {
        val currentTime = Calendar.getInstance().time
        val diff = currentTime.time - it.time

        return if (diff > 0) {
            TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS)
        } else {
            0
        }
    }

    return 0
}

fun String.showRemainTime(context: Context): String {
    return when (val days = this.getTimeRemain()) {
        0L -> context.getString(R.string.today)
        -1L -> context.getString(R.string.overdue)
        else -> this.showFutureTime(context, days)
    }
}

fun String.showPastTime(context: Context): String {
    return when (val days = this.getPastTime()) {
        0L -> context.getString(R.string.today)
        in 1..30 -> String.format(context.getString(R.string.day_ago), days)
        in 31..365 -> String.format(context.getString(R.string.month_ago), days / 30)
        in 366..Int.MAX_VALUE -> String.format(context.getString(R.string.year_ago), days / 365)
        else -> ""
    }
}

fun String.showFutureTime(context: Context): String {
    return when (val days = this.getFutureTime()) {
        0L -> context.getString(R.string.today)
        in 1..30 -> String.format(context.getString(R.string.day_left_future), days)
        in 31..365 -> String.format(context.getString(R.string.month_left), days / 30)
        in 366..Int.MAX_VALUE -> String.format(context.getString(R.string.year_left), days / 365)
        else -> context.getString(R.string.overdue)
    }
}

fun String.showFutureTime(context: Context, days: Long): String {
    return when (days) {
        0L -> context.getString(R.string.today)
        in 1..30 -> String.format(context.getString(R.string.day_left_future), days)
        in 31..365 -> String.format(context.getString(R.string.month_left), days / 30)
        in 366..Int.MAX_VALUE -> String.format(context.getString(R.string.year_left), days / 365)
        else -> context.getString(R.string.overdue)
    }
}

fun String.showCompactTime(context: Context): String {
    this.getDate()?.let {
        val currentTime = Calendar.getInstance()
        currentTime.setToMidNight()

        return if (it.before(currentTime.time)) {
            this.showPastTime(context)
        } else {
            this.showFutureTime(context)
        }
    }

    return ""
}

@SuppressLint("SimpleDateFormat")
fun String.convertDateFormatServerToClient(): String {
    return try {
        val date = dateFactory.serverDateFormat.parse(this)

        dateFactory.clientDateFormat.format(date)
    } catch (e: Exception) {
        Log.w(
            Constants.TAG_DATE_TIME_FORMAT_EXTENSION,
            "Unable to parser date format from server to client"
        )
        this
    }
}

fun String.getDurationFromCurrent(context: Context): String {
    return when (val seconds = this.getDiffTimeBySecond()) {
        in 0L..59L -> context.getString(R.string.time_duration_s, seconds)
        in 60..3600 -> String.format(context.getString(R.string.time_duration_m), seconds / 60)
        in 3600..86400 -> String.format(context.getString(R.string.time_duration_h), seconds / 3600)
        in 86400..2592000 -> String.format(
            context.getString(R.string.time_duration_d),
            seconds / 86400
        )
        in 2592000..31536000 -> String.format(
            context.getString(R.string.time_duration_month),
            seconds / 2592000
        )
        in 31536000..Int.MAX_VALUE -> String.format(
            context.getString(R.string.time_duration_y),
            seconds / 31536000
        )
        else -> ""
    }
}

@SuppressLint("SimpleDateFormat")
fun String.formatTimeNotification(): String {
    return try {
        val date = this.getDate()

        dateFactory.lastUpdateFormat.format(date)
    } catch (e: Exception) {
        Log.w(Constants.TAG_DATE_TIME_FORMAT_EXTENSION, "DateTime convert notification failed")
        ""
    }
}

@SuppressLint("SimpleDateFormat")
fun String.formatDateNotification(): String {
    return try {
        val date = this.getDate()

        dateFactory.clientDateFormat.format(date)
    } catch (e: Exception) {
        Log.w(Constants.TAG_DATE_TIME_FORMAT_EXTENSION, "DateTime convert date failed")
        ""
    }
}

@SuppressLint("SimpleDateFormat")
fun String.formatDateToServer(): String {
    return try {
        val date = this.getDate()

        dateFactory.serverDateFormat.format(date)
    } catch (e: Exception) {
        Log.w(Constants.TAG_DATE_TIME_FORMAT_EXTENSION, "DateTime convert date failed")
        ""
    }
}

@SuppressLint("SimpleDateFormat")
fun String.lastUpdate(): String {
    return try {
        val date = dateFactory.lastUpdateServer.parse(this)

        dateFactory.lastUpdateFormat.format(date)
    } catch (e: Exception) {
        this
    }
}


@SuppressLint("SimpleDateFormat")
fun String.formatBodFromServer(): String {
    val date = dateFactory.serverDateFormat.parse(this)

    return dateFactory.clientDateFormat.format(date)
}

@SuppressLint("SimpleDateFormat")
fun String.formatToServer(): String {
    val date = dateFactory.clientDateFormat.parse(this)

    return dateFactory.serverDateFormat.format(date)
}

@SuppressLint("SimpleDateFormat")
fun String.formatToServerDate(): Date {
    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    return dateFactory.clientDateFormat.parse(this)
}

@SuppressLint("SimpleDateFormat")
fun String.formatDobServer(): String? {
    return when {
        this.isBlank() -> {
            this
        }
        else -> {
            try {
                val date = dateFactory.clientDateFormat.parse(this)
                dateFactory.serverDateFormat.format(date)
            } catch (e: java.lang.Exception) {
                null
            }
        }
    }
}

@SuppressLint("SimpleDateFormat")
fun Date.convertDateFormatServerToClient(): String {
    return dateFactory.clientDateFormat.format(this)
}

@SuppressLint("SimpleDateFormat")
fun Date.convertDateFormatServer(): String {
    return dateFactory.serverDateFormat.format(this)
}

@SuppressLint("SimpleDateFormat")
fun Date.getMonth(context: Context): String {
    return SimpleDateFormat(context.resources.getString(R.string.month_format)).format(this)
}

@SuppressLint("SimpleDateFormat")
fun String.dobToAPI(): String {
    val date = dateFactory.clientDateFormat.parse(this)

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    return dateFactory.serverDateFormat.format(date)
}

fun DatePicker.getDate(): Date {
    val calendar = Calendar.getInstance()
    calendar.set(year, month, dayOfMonth)
    return calendar.time
}

fun String.parseExpectedDate(): Date {
    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    return dateFactory.uiDobInput.parse(this)
}

fun Date.toIso8601(): String {
    return try {
        dateFactory.iso8601.format(this)
    } catch (e: Exception) {
        ""
    }
}

@SuppressLint("SimpleDateFormat")
fun String.parseDoB(): Date? {
    return try {
        return dateFactory.serverDateFormat.parse(this)
    } catch (e: Exception) {
        Log.w(Constants.TAG_DATE_TIME_FORMAT_EXTENSION, "Unable to parser dob")
        null
    }
}

@SuppressLint("SimpleDateFormat")
fun String.parserServerTime(): Date? {
    return try {
        return dateFactory.serverDateFormat.parse(this)
    } catch (e: Exception) {
        Log.w(Constants.TAG_DATE_TIME_FORMAT_EXTENSION, "Unable to parser server time")
        null
    }
}

fun Date?.toDateSort(default: String = ""): String {
    return try {
        dateFactory.dateTimeSort.format(this)
    } catch (e: Exception) {
        default
    }
}

fun Date?.toDateFull(default: String = ""): String {
    return try {
        dateFactory.dateTimeFull.format(this)
    } catch (e: Exception) {
        default
    }
}

