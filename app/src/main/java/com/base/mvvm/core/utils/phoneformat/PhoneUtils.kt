package com.base.mvvm.core.utils.phoneformat

import android.content.Context
import com.base.mvvm.core.widget.extension.formatPhoneNumberWithCountryCode
import com.base.mvvm.core.widget.extension.isCellPhoneValid
import com.vinmec.onevinmec.utils.phoneformat.Countries
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil
import io.michaelrocks.libphonenumber.android.Phonenumber

class PhoneUtils(val phoneUtil: PhoneNumberUtil) {
    companion object {
        @Volatile
        private var INSTANCE: PhoneUtils? = null

        val countries = Countries.countries

        fun getInstance(context: Context): PhoneUtils =
            INSTANCE
                ?: synchronized(this) {
                    INSTANCE
                        ?: PhoneUtils(
                            PhoneNumberUtil.createInstance(context)
                        ).also { INSTANCE = it }
                }
    }

    fun isValidMobileNumber(phoneWithCountry: String?): Boolean {
        val mobileNo = phoneWithCountry?.formatPhoneNumberWithCountryCode()

        if (mobileNo?.isBlank() == true || mobileNo?.isCellPhoneValid() == false) {
            return false
        }

        try {
            for ((_, _, dCode) in countries) {
                val phNumberProto: Phonenumber.PhoneNumber = phoneUtil.parse(
                    mobileNo, dCode
                )

                if (phoneUtil.isValidNumber(phNumberProto)) {
                    return true
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return false
    }
}