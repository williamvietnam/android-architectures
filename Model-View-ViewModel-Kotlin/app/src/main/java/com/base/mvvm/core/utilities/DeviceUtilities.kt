package com.base.mvvm.core.utilities

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Point
import android.graphics.Rect
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.hardware.camera2.CameraMetadata
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.ContactsContract
import android.provider.Settings
import android.telephony.TelephonyManager
import android.text.TextUtils
import android.util.DisplayMetrics
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ProcessLifecycleOwner

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
class DeviceUtilities {

    companion object {

        fun convertToMap(obj: Any): Map<String, Any> {
            val map: MutableMap<String, Any> = mutableMapOf()
            for (field in obj.javaClass.declaredFields) {
                field.isAccessible = true
                try {
                    if (field[obj] != null) {
                        map[field.name] = field[obj]
                    }
                } catch (e: Exception) {
                }
            }
            return map
        }

        fun isAppVisible(): Boolean {
            return ProcessLifecycleOwner
                .get()
                .lifecycle
                .currentState
                .isAtLeast(Lifecycle.State.STARTED)
        }

        fun isHasCameraHardware(context: Context): Boolean {
            return try {
                var backCameraId: String? = null
                val manager =
                    context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
                for (cameraId in manager.cameraIdList) {
                    val cameraCharacteristics =
                        manager.getCameraCharacteristics(cameraId!!)
                    val facing =
                        cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)
                    if (facing != null && facing == CameraMetadata.LENS_FACING_BACK) {
                        backCameraId = cameraId
                        break
                    }
                }
                backCameraId != null
            } catch (e: Exception) {
                false
            }
        }

        fun isSimCardPresent(context: Context): Boolean {
            val tm =
                context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager //gets the current TelephonyManager
            return tm.simState != TelephonyManager.SIM_STATE_ABSENT
        }

        fun hideSoftKeyboard(activity: Activity?) {
            if (activity != null && activity.window != null) {
                val imm =
                    activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(
                    activity.window.decorView.windowToken, 0
                )
            }
        }

        fun showSoftKeyboard(activity: Activity?) {
            if (activity != null && activity.window != null) {
                val imm =
                    activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
            }
        }

        fun getStatusBarHeight(context: Context): Int {
            var result = 0
            val resourceId =
                context.resources.getIdentifier("status_bar_height", "dimen", "android")
            if (resourceId > 0) {
                result = context.resources.getDimensionPixelSize(resourceId)
            }
            return result
        }

        fun clearFocus(activity: Activity?) {
            if (activity != null && activity.currentFocus != null) {
                activity.currentFocus!!.clearFocus()
            }
        }

        fun isValidPhoneNo(iPhoneNo: CharSequence): Boolean {
            return !TextUtils.isEmpty(iPhoneNo) &&
                    Patterns.PHONE.matcher(iPhoneNo).matches()
        }

        fun showDialogSetting(context: Context) {
            val intent = Intent()
            intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            val uri =
                Uri.fromParts("package", context.packageName, null)
            intent.data = uri
            context.startActivity(intent)
        }

        val isSDCardPresent: Boolean
            get() = Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED

        fun getAndroidId(context: Context): String {
            return Settings.Secure.getString(
                context.contentResolver,
                Settings.Secure.ANDROID_ID
            )
        }

        fun isAirplaneModeOn(context: Context): Boolean {
            return Settings.System.getInt(
                context.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON, 0
            ) != 0
        }

        //create new contact
        private fun insertContactDisplayName(
            context: Context,
            addContactsUri: Uri,
            rawContactId: Long,
            displayName: String
        ) {
            val contentValues = ContentValues()
            contentValues.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId)
            contentValues.put(
                ContactsContract.Data.MIMETYPE,
                ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE
            )
            contentValues.put(
                ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME,
                displayName
            )
            context.contentResolver.insert(addContactsUri, contentValues)
        }

        private fun insertContactPhoneNumber(
            context: Context,
            addContactsUri: Uri,
            rawContactId: Long,
            phoneNumber: String,
            phoneTypeStr: String
        ): Boolean {
            return try {
                val contentValues = ContentValues()
                contentValues.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId)
                contentValues.put(
                    ContactsContract.Data.MIMETYPE,
                    ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE
                )
                contentValues.put(ContactsContract.CommonDataKinds.Phone.NUMBER, phoneNumber)
                var phoneContactType = ContactsContract.CommonDataKinds.Phone.TYPE_HOME
                when {
                    "home".equals(phoneTypeStr, ignoreCase = true) -> {
                        phoneContactType = ContactsContract.CommonDataKinds.Phone.TYPE_HOME
                    }
                    "mobile".equals(phoneTypeStr, ignoreCase = true) -> {
                        phoneContactType = ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE
                    }
                    "work".equals(phoneTypeStr, ignoreCase = true) -> {
                        phoneContactType = ContactsContract.CommonDataKinds.Phone.TYPE_WORK
                    }
                }
                contentValues.put(ContactsContract.CommonDataKinds.Phone.TYPE, phoneContactType)
                context.contentResolver.insert(addContactsUri, contentValues)
                true
            } catch (e: Exception) {
                false
            }
        }

        fun isShowKeyboard(view: View): Boolean {
            val softKeyboardHeight = 100
            val rect = Rect()
            view.getWindowVisibleDisplayFrame(rect)
            val dm = view.resources.displayMetrics
            val heightDiff = view.bottom - rect.bottom
            return heightDiff > softKeyboardHeight * dm.density
        }

        fun getScreenHeight(context: Activity): Int {
            val displayMetrics = DisplayMetrics()
            context.windowManager.defaultDisplay.getMetrics(displayMetrics)
            return displayMetrics.heightPixels
        }

        fun getDeviceName(): String {
            return Build.MANUFACTURER + " " + Build.MODEL
        }

        fun getWidthScreen(activity: Activity): Int {
            val displayMetrics = DisplayMetrics()
            activity.windowManager?.defaultDisplay?.getMetrics(displayMetrics)
            return displayMetrics.widthPixels
        }

        private fun capitalize(str: String): String {
            if (TextUtils.isEmpty(str)) {
                return str
            }
            val arr = str.toCharArray()
            var capitalizeNext = true
            val phrase = StringBuilder()
            for (c in arr) {
                if (capitalizeNext && Character.isLetter(c)) {
                    phrase.append(Character.toUpperCase(c))
                    capitalizeNext = false
                    continue
                } else if (Character.isWhitespace(c)) {
                    capitalizeNext = true
                }
                phrase.append(c)
            }
            return phrase.toString()
        }

        fun getRealScreen(context: Context): Point {
            return try {
                val wm = context
                    .getSystemService(Context.WINDOW_SERVICE) as WindowManager
                val display = wm.defaultDisplay
                val point = Point()
                display.getRealSize(point)
                point
            } catch (e: NoSuchMethodError) {
                val screenSize: IntArray = getScreenSize(context)
                Point(screenSize[0], screenSize[1])
            }
        }

        fun getScreenSize(context: Context): IntArray {
            val size = IntArray(2)
            val wm = context
                .getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = wm.defaultDisplay
            val outSize = Point()
            display.getSize(outSize)
            size[0] = outSize.x
            size[1] = outSize.y
            return size
        }
    }
}