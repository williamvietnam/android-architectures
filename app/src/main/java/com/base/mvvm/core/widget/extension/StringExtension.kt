package com.base.mvvm.core.widget.extension

import android.content.Context
import android.net.Uri
import android.util.Log
import android.util.Patterns
import com.base.mvvm.R
import com.base.mvvm.core.utils.Constants
import java.security.MessageDigest
import kotlin.math.roundToInt

fun Uri.getSlug(): String? {
    return encodedPath?.replace("/vi", "")
}

fun String.formatStringToHidden(): String {
    // format Email
    if (this.isEmailValid()) {
        var email = ""
        val prefix = this.substring(0, this.indexOf("@"))

        val positionHidden = when (prefix.length) {
            1 -> {
                0
            }
            in 2..3 -> {
                1
            }
            4 -> {
                2
            }
            else -> {
                4
            }
        }
        if (prefix.length <= 4) {
            for (i in positionHidden until prefix.length) {
                email += "*"
            }
            return "${this.substring(0, positionHidden)}$email${
                this.substring(
                    this.indexOf("@"),
                    this.length
                )
            }"
        } else {
            for (i in positionHidden until prefix.length) {
                email += "*"
            }
            return "${this.substring(0, positionHidden)}$email${
                this.substring(
                    this.indexOf("@"),
                    this.length
                )
            }"
        }
    }
    // format Phone number
    if (this.isCellPhoneValid()) {
        var number = ""
        for (i in 0 until this.length - 4) {
            number += "*"
        }
        return "$number${this.substring(this.length - 4, this.length)}"
    }
    return ""
}

fun String.isEmailValid(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isCellPhoneValid(): Boolean {
    if (this.length < 10 || this.length > 15) {
        return false
    }
    return Patterns.PHONE.matcher(this).matches()
}

fun String.formatPhoneNumberWithCountryCode(): String {
    if (!this.isCellPhoneValid()) {
        Log.d(Constants.TAG_STRING_EXTENSION, "The phone number entered is not valid")
        return ""
    }
    return if (this.substring(0, 1) == "0") {
        "${"+84"}${this.substring(1, this.length)}"
    } else {
        if (this.startsWith("+84") || this.startsWith("+")) this else
            "${"+84"}$this"
    }
}

fun String.phoneRemoveCountry(): String {
    if (this.startsWith("+84")) {
        return this.replace("+84", "0")
    }
    return this
}

fun String.formatToken(): String {
    return if (this.startsWith("JWT")) this else "JWT $this"
}

fun String.removeJWT(): String {
    return if (this.startsWith("JWT")) this.replaceFirst("JWT ", "") else this
}

fun String.toCapital(): String {
    return this.split(' ').joinToString(" ") { it.capitalize() }
}

fun String.saltThenHash(): String {
    return "Zen8LabsNumber$this".hash256()
}

fun String.hash256(): String {
    val bytes = this.toByteArray()
    val md = MessageDigest.getInstance("SHA-256")
    val digest = md.digest(bytes)
    return digest.fold("", { str, it -> str + "%02x".format(it) })
}

fun String.getIntValue(): Int {
    val value = this.toIntOrNull()
    if (value != null) {
        return value
    }

    if (this.contains("k", ignoreCase = true)) {
        val number = this.replace("k", "", ignoreCase = true)
        val convertValue = number.toFloatOrNull()
        if (convertValue != null) {
            return (convertValue * 1000).roundToInt()
        }
    }

    if (this.contains("m", ignoreCase = true)) {
        val number = this.replace("m", "", ignoreCase = true)
        val convertValue = number.toFloatOrNull()
        if (convertValue != null) {
            return (convertValue * 1000000).roundToInt()
        }
    }

    return 0
}

fun String.discountDurationFmt(
    context: Context,
    startDate: String?,
    endDate: String?
): String {
    val start = startDate?.parserServerTime()
    val end = endDate?.parserServerTime()

    if (startDate == null || startDate.isEmpty()) {
        return ""
    } else if (endDate == null || endDate.isEmpty()) {
        return context.getString(
            R.string.discount_duration_start_fmt,
            start.toDateFull("-")
        )
    }

    return if (start?.year == end?.year) {
        context.getString(
            R.string.discount_duration_fmt,
            start.toDateSort(""),
            end.toDateFull("")
        )
    } else {
        context.getString(
            R.string.discount_duration_fmt,
            start.toDateFull(""),
            end.toDateFull("")
        )
    }
}

fun String?.formatPhoneDisplay(): String {
    if (this != null) {
        return this.replace("+840", "0").replace("+84", "0")
    }

    return ""
}


