package com.example.loading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
//import com.example.loading.ui.main.MainFragment
import android.webkit.*

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.presentation)
    }

        fun web(view: View){
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
            webView.loadUrl("https://www.loading.se")
        }
}
