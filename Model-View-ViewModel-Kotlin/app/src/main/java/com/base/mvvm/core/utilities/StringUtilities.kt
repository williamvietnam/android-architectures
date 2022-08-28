package com.base.mvvm.core.utilities

import android.content.Context
import android.text.TextUtils
import android.util.Patterns
import com.base.mvvm.core.utilities.EdtState.EDT_EMPTY
import com.base.mvvm.core.utilities.EdtState.EDT_LENGTH_INVALID
import com.base.mvvm.core.utilities.EdtState.EDT_NOT_HALFWIDTH_OR_DIGIT
import com.base.mvvm.core.utilities.EdtState.SUCCESS
import java.net.URLDecoder
import java.security.MessageDigest
import java.util.regex.Pattern

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
object EdtState {
    const val EDT_EMPTY = 0
    const val EDT_NOT_HALFWIDTH_OR_DIGIT = 1
    const val EDT_LENGTH_INVALID = 2
    const val SUCCESS = 3
}

object StringUtils {

    fun String.validatepassword(): Int {
        if (TextUtils.isEmpty(this) || TextUtils.isEmpty(this.trim())) {
            return EDT_EMPTY
        }

        if (!Pattern.compile("^[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#\$%&'()-^@[;:],./=~|`{+*}<>?_]{0,100}$")
                .matcher(this).matches()
        ) {
            return EDT_NOT_HALFWIDTH_OR_DIGIT
        }

        val length = this.trim().length
        if (length > 100 || length < 6) {
            return EDT_LENGTH_INVALID
        }

        return SUCCESS
    }

    fun String.validateUserId(): Int {
        if (TextUtils.isEmpty(this) || TextUtils.isEmpty(this.trim())) {
            return EDT_EMPTY
        }

        if (!Pattern.compile("^[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#\$%&'()-^@[;:],./=~|`{+*}<>?_]{0,20}$")
                .matcher(this).matches()
        ) {
            return EDT_NOT_HALFWIDTH_OR_DIGIT
        }

        val length = this.trim().length
        if (length > 20) {
            return EDT_LENGTH_INVALID
        }

        return SUCCESS
    }

    fun String.isDouble(): Boolean {
        return try {
            this.toDouble()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    fun List<Any>.toStringList(): String {
        return this.joinToString(",")
    }

    val String.md5: String
        get() {
            val bytes = MessageDigest.getInstance("MD5").digest(this.toByteArray())
            return bytes.joinToString("") {
                "%02x".format(it)
            }
        }

    val String.sha1: String
        get() {
            val bytes = MessageDigest.getInstance("SHA-1").digest(this.toByteArray())
            return bytes.joinToString("") {
                "%02x".format(it)
            }
        }

    fun CharSequence?.isValidEmail() =
        !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

    fun String.isEmailValid(): Boolean {
        val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,8}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(this)
        return matcher.matches()
    }

    fun createRoomIdFromIds(myId: String, partnerId: String): String {
        return if (myId < partnerId) {
            myId + partnerId
        } else {
            partnerId + myId
        }
    }

    val String.containsLatinLetter: Boolean
        get() = matches(Regex(".*[A-Za-z].*"))

    val String.containsDigit: Boolean
        get() = matches(Regex(".*[0-9].*"))

    val String.isAlphanumeric: Boolean
        get() = matches(Regex("[A-Za-z0-9]*"))

    val String.hasLettersAndDigits: Boolean
        get() = containsLatinLetter && containsDigit

    val String.isIntegerNumber: Boolean
        get() = toIntOrNull() != null

    val String.toDecimalNumber: Boolean
        get() = toDoubleOrNull() != null

    fun String.save(
        applicationContext: Context,
        value: Map<String, Any>,
        clear: Boolean = false,
        now: Boolean = false
    ) {
        val sp = applicationContext.getSharedPreferences(this, Context.MODE_PRIVATE).edit()
        if (clear)
            sp.clear()
        value.keys.forEach { key ->
            val v = value[key]
            if (v != null) {
                when (v) {
                    is String -> sp.putString(key, v)
                    is Float -> sp.putFloat(key, v)
                    is Long -> sp.putLong(key, v)
                    is Int -> sp.putInt(key, v)
                    is Boolean -> sp.putBoolean(key, v)
                }
            }
        }
        if (now)
            sp.commit()
        else
            sp.apply()
    }

    fun String.load(applicationContext: Context): Map<String, Any> {
        val sp = applicationContext.getSharedPreferences(this, Context.MODE_PRIVATE)
        val keys = sp.all.keys
        val result = hashMapOf<String, Any>()
        keys.map { key ->
            val v = sp.all[key]
            if (v != null)
                result[key] = v
        }
        return result
    }

    val String.lastPathComponent: String
        get() {
            var path = this
            if (path.endsWith("/"))
                path = path.substring(0, path.length - 1)
            var index = path.lastIndexOf('/')
            if (index < 0) {
                if (path.endsWith("\\"))
                    path = path.substring(0, path.length - 1)
                index = path.lastIndexOf('\\')
                if (index < 0)
                    return path
            }
            return path.substring(index + 1)
        }

    val String.creditCardFormatted: String
        get() {
            val preparedString = replace(" ", "").trim()
            val result = StringBuilder()
            for (i in preparedString.indices) {
                if (i % 4 == 0 && i != 0) {
                    result.append(" ")
                }
                result.append(preparedString[i])
            }
            return result.toString()
        }

    fun getParameter(string: String, prefixName: String): String {
        val params = string.split("&")
        var value = ""
        val prefix = "$prefixName="
        for (param in params) {
            if (param.startsWith(prefix)) {
                value = param.substringAfter(prefix)
                break
            }
        }
        return value
    }

    fun handleNameDecoder(string: String, enc: String, charsets: String): String {
        return String(
            URLDecoder.decode(string, charsets).toByteArray(charset(charsets)),
            charset(enc)
        )
    }
}