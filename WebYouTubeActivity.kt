package com.example.youtubeclone

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class WebYouTubeActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_youtube)

        webView = findViewById(R.id.webViewYouTube)

        // JavaScript ဖွင့်ပေးရန် (YouTube အလုပ်လုပ်ရန် မဖြစ်မနေ လိုအပ်သည်)
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true

        // App ထဲတွင်ပင် Link များ ဆက်လက်ပွင့်စေရန်
        webView.webViewClient = WebViewClient()

        // YouTube Website သို့ ဝင်ရောက်ရန်
        webView.loadUrl("https://www.youtube.com")
    }

    // ဖုန်း၏ Back ခလုတ်နှိပ်ပါက Web တွင် ရှေ့စာမျက်နှာသို့ ပြန်သွားရန်
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
