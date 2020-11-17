package com.example.loading

import android.os.Bundle
import android.webkit.WebView
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.main_activity.*

class Browser: AppCompatActivity() {
    private lateinit var webView: WebView
    private var currentURL = "https://www.loading.se"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

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

        swipe.setOnRefreshListener {
            currentURL = webView.url
            webView.loadUrl(currentURL)
            swipe.isRefreshing = false

        }
    }
}