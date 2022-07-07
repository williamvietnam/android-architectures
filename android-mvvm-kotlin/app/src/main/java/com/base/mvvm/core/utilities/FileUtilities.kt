package com.base.mvvm.core.utilities

import android.content.Context
import android.os.Environment
import java.io.File

const val JPEG = ".jpg"
const val PNG = ".png"

class FileUtils {
//    fun saveFileInAppDirectory(context: Context) {
//        val file = createFileInStorage(context,
//            "test.jpeg"
//        )
//        Timber.d("file path %s", file!!.absolutePath)
//        if (!file.exists()) {
//            file.createNewFile()
//        }
//        val assetManager = context.assets
//        val inputStream: InputStream
//        val bitmap: Bitmap
//        try {
//            inputStream = assetManager.open(SAMPLE_FILE_NAME)
//            bitmap = BitmapFactory.decodeStream(inputStream)
//            saveBitmap(bitmap, file)
//        } catch (e: Exception) {
//            Timber.e(e)
//        }
//    }

//    fun saveFileInAppExternalDirectory(appContext: Context) {
//        val file = createFileInExternalStorage(appContext,
//            "test.jpeg"
//        )
//        Timber.d("file path %s", file!!.absolutePath)
//        if (!file.exists()) {
//            file.createNewFile()
//        }
//        val assetManager = appContext.assets
//        val inputStream: InputStream
//        val bitmap: Bitmap
//        try {
//            inputStream = assetManager.open(SAMPLE_FILE_NAME)
//            bitmap = BitmapFactory.decodeStream(inputStream)
//            saveBitmap(bitmap, file)
//        } catch (e: Exception) {
//            Timber.e(e)
//        }
//    }

    fun createFileInStorage(context: Context, fileName: String): File? {
        val timeStamp: String = System.currentTimeMillis().toString() + JPEG
        val name = if (fileName.isBlank()) timeStamp else fileName
        return File(getAppFilesDir(context), name)
    }

    fun createFileInExternalStorage(context: Context, fileName: String): File? {
        val timeStamp: String = System.currentTimeMillis().toString() + JPEG
        val name = if (fileName.isBlank()) timeStamp else fileName
        return File(getAppExternalFilesDir(context), name)
    }

    private fun getAppFilesDir(context: Context): File? {
        val file = context.filesDir
        if (file != null && !file.exists()) {
            file.mkdirs()
        }
        return file
    }

    private fun getAppExternalFilesDir(context: Context): File? {
        val file = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        if (file != null && !file.exists()) {
            file.mkdirs()
        }
        return file
    }
}