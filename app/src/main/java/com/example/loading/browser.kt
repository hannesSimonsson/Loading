package com.example.loading

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.main_activity.*

// Everything regarding web is handled here
class Browser: AppCompatActivity() {
    private lateinit var webView: WebView
    private var currentURL = "https://www.loading.se"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        // Make status bar align with webview
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        val height : Int
        height = if (resourceId > 0)
            resources.getDimensionPixelSize(resourceId)
        else
            0

        val param = swipe.layoutParams as ViewGroup.MarginLayoutParams
        param.setMargins(0,height,0,0)
        swipe.layoutParams = param

        // Set up web client
        webView = findViewById(R.id.webview)
        webView.settings.setJavaScriptEnabled(true)
        webView.settings.setDomStorageEnabled(true);

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)

                return true
            }
        }
        webView.loadUrl(currentURL)
    }

    override fun onStart() {
        super.onStart()

        // #fd2860 : Color
        swipe.setColorSchemeColors(16590944)

        // Pull down refresh
        swipe.setOnRefreshListener {
            currentURL = webView.url
            webView.loadUrl(currentURL)
            swipe.isRefreshing = false
        }
    }
}

