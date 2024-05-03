package com.dostonbek.megapaneluz

import android.annotation.SuppressLint

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.dostonbek.megapaneluz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.webView.webViewClient= WebViewClient()
        binding.webView.loadUrl("https://megapanel.uz/")
        binding.webView.settings.javaScriptEnabled=true
        binding.webView.settings.setSupportZoom(true)
        if (!NetworkUtils.isNetworkAvailable(this)) {
            showNoInternetDialog()
        }


    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        }else




        super.onBackPressed()
    }
    private fun showNoInternetDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Internet is disconnected")

        builder.setMessage("Please check your internet connection")
            .setPositiveButton("Try Again") { dialog, which ->
                // Check internet connection again
                if (!NetworkUtils.isNetworkAvailable(this@MainActivity)) {
                    // Show the dialog again if the internet is still disconnected
                    showNoInternetDialog()
                }
            }


        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
        alertDialog.setCanceledOnTouchOutside(false)

    }
}

