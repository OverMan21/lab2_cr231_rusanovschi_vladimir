package com.example.lab2v2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOf(R.id.product1, R.id.product2, R.id.product3).forEach { id ->
            findViewById<View>(id).setOnClickListener {
                startActivity(Intent(this, ProductActivity::class.java))
            }
        }
    }
}