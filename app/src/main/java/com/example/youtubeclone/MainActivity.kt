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
        setContentView(R.layout.activity_main)

        // Toolbar ချိတ်ဆက်ခြင်း
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        if (toolbar != null) {
            setSupportActionBar(toolbar)
            supportActionBar?.title = "YouTube Clone"
        }

        // WebView ကို ချိတ်ဆက်ခြင်း
        webView = findViewById(R.id.webView)
        webView?.let { wv ->
            // WebViewClient ဖြင့် လင့်ခ်များကို App ထဲမှာပဲ ပွင့်စေရန်
            wv.webViewClient = WebViewClient()
            
            // WebChromeClient ဖြင့် Video များနှင့် JavaScript rendering များကို ပံ့ပိုးပေးရန်
            wv.webChromeClient = WebChromeClient()

            val webSettings: WebSettings = wv.settings
            webSettings.javaScriptEnabled = true
            webSettings.domStorageEnabled = true
            webSettings.databaseEnabled = true
            webSettings.loadsImagesAutomatically = true
            webSettings.mediaPlaybackRequiresUserGesture = false // ဗီဒီယိုများ အလိုအလျောက် အလုပ်လုပ်ရန်
            webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            
            // Desktop/Mobile Browser အဖြစ် ဟန်ဆောင်ရန် User-Agent သတ်မှတ်ခြင်း
            webSettings.userAgentString = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"

            // YouTube ပင်မစာမျက်နှာ သို့မဟုတ် Embed များကို တိုက်ရိုက်ဖွင့်ခြင်း
            wv.loadUrl("https://www.youtube.com")
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
