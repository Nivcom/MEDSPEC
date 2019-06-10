package com.example.medspec

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(webview !=null){
           val webSettings = webview!!.settings
            webSettings.javaScriptEnabled = true

            webview!!.webViewClient = WebViewClient()
            webview!!.webChromeClient = WebChromeClient()
            webview!!.loadUrl("http://optimamines.com/medspec/")



            webview!!. webViewClient = object: WebViewClient(){
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                   progressBar.visibility = View.VISIBLE
                    super.onPageStarted(view, url, favicon)
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                   progressBar.visibility = View.GONE
                    super.onPageFinished(view, url)
                }

            }
        }
    }

    override fun onBackPressed() {
        if (webview!!.canGoBack()){
            webview!!.goBack()
        }
        else {
            super.onBackPressed()
        }
    }
}
