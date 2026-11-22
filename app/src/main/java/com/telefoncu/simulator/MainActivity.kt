package com.telefoncu.simulator

import android.app.Activity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : Activity() {
    private lateinit var game: WebView
    @Suppress("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        game = WebView(this)
        game.settings.javaScriptEnabled = true
        game.settings.domStorageEnabled = true
        game.settings.allowFileAccess = true
        game.settings.allowContentAccess = false
        game.webViewClient = WebViewClient()
        game.webChromeClient = WebChromeClient()
        game.loadUrl("file:///android_asset/index.html")
        setContentView(game)
    }
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (::game.isInitialized && game.canGoBack()) game.goBack() else super.onBackPressed()
    }
}
