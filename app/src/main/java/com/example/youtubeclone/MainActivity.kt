package com.example.youtubeclone

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private var webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_main)

            // Toolbar ချိတ်ဆက်ခြင်း
            val toolbar = findViewById<Toolbar>(R.id.toolbar)
            if (toolbar != null) {
                setSupportActionBar(toolbar)
                supportActionBar?.title = "YouTube"
            }

            // WebView ကို ဘေးကင်းစွာ ချိတ်ဆက်ပြီး YouTube ဖွင့်ခြင်း
            webView = findViewById(R.id.webView)
            webView?.let { wv ->
                wv.webViewClient = WebViewClient()
                
                val webSettings: WebSettings = wv.settings
                webSettings.javaScriptEnabled = true
                webSettings.domStorageEnabled = true
                webSettings.loadWithOverviewMode = true
                webSettings.useWideViewPort = true

                wv.loadUrl("https://www.youtube.com")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onBackPressed() {
        if (webView != null && webView!!.canGoBack()) {
            webView!!.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
