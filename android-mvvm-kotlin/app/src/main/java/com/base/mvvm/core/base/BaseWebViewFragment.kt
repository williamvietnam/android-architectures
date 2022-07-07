package com.base.mvvm.core.base

import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

abstract class BaseWebViewFragment<BD : ViewDataBinding, VM : BaseViewModel>(@LayoutRes id: Int) :
    SaveViewBaseFragment<BD, VM>(id) {

    fun WebView.loadData(url: String) {
        webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                showHideLoading(true)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                showHideLoading(false)
            }
        }

        apply {
            settings.javaScriptEnabled = true
            settings.javaScriptCanOpenWindowsAutomatically = true
            settings.domStorageEnabled = true
            settings.useWideViewPort = true
            settings.loadWithOverviewMode = true
            settings.allowContentAccess = true
            settings.allowFileAccess = true
            settings.databaseEnabled = true
            settings.setSupportZoom(true)
            loadUrl(url)
        }
    }
}