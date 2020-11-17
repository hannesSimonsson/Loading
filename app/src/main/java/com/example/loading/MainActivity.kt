package com.example.loading

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.presentation)
    }

    fun web(view: View) {
        val intent = Intent(this, Browser::class.java)
        startActivity(intent)
    }
}
