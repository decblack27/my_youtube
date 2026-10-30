package com.example.youtubeclone

import android.os.Bundle
import android.webkit.WebChromeClient
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
                supportActionBar?.title = "YouTube Clone"
            }

            // WebView ကို ဘေးကင်းစွာ ချိတ်ဆက်ခြင်း
            webView = findViewById(R.id.webView)
            webView?.let { wv ->
                wv.webViewClient = object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                        url?.let { view?.loadUrl(it) }
                        return true
                    }
                }
                
                wv.webChromeClient = WebChromeClient()

                val webSettings: WebSettings = wv.settings
                webSettings.javaScriptEnabled = true
                webSettings.domStorageEnabled = true
                webSettings.databaseEnabled = true
                webSettings.loadsImagesAutomatically = true
                webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

                // YouTube Mobile site သို့ဝင်ရောက်ခြင်း (Crash မဖြစ်စေရန်)
                wv.loadUrl("https://m.youtube.com")
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
