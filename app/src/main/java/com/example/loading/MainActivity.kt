package com.example.loading

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View

// Show presentation screen, web() called from presentation.xml
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.apply{systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN}
        setContentView(R.layout.presentation)

        val intent = Intent(this, Browser::class.java)
        Handler().postDelayed( {
            startActivity(intent) }, 350
        )
    }

    fun web(view: View) {
        val intent = Intent(this, Browser::class.java)
        startActivity(intent)
    }
}
