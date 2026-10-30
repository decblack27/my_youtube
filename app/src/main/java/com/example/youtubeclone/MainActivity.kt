package com.example.youtubeclone

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toolbar ချိတ်ဆက်ခြင်း
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        if (toolbar != null) {
            setSupportActionBar(toolbar)
            supportActionBar?.title = "YouTube"
        }

        // WebView ချိတ်ဆက်ပြီး YouTube ဖွင့်ခြင်း
        webView = findViewById(R.id.webView)
        webView.webViewClient = WebViewClient() // App ထဲမှာပဲ လင့်ခ်ပွင့်စေရန်
        
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true // YouTube ဗီဒီယိုများ အလုပ်လုပ်ရန် JavaScript ဖွင့်ပေးခြင်း
        webSettings.domStorageEnabled = true

        // YouTube လိပ်စာသို့ ဝင်ရောက်ခြင်း
        webView.loadUrl("https://www.youtube.com")
    }

    // ဖုန်းရဲ့ Back ခလုတ်နှိပ်ရင် Website မှာ နောက်သို့ပြန်သွားရန် (Exit မဖြစ်သွားစေရန်)
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
