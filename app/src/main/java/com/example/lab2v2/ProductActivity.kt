package com.example.lab2v2

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProductActivity : AppCompatActivity() {

    private var isFavorite = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        findViewById<View>(R.id.btnBack).setOnClickListener { finish() }

        val heart = findViewById<ImageView>(R.id.btnFavorite)
        heart.setOnClickListener {
            isFavorite = !isFavorite
            if (isFavorite) heart.clearColorFilter() else heart.setColorFilter(Color.parseColor("#C8C8D0"))
        }

        val sizes = listOf(R.id.sizeS, R.id.sizeM, R.id.sizeL).map { findViewById<TextView>(it) }
        sizes.forEach { selected ->
            selected.setOnClickListener {
                sizes.forEach { s ->
                    val on = s == selected
                    s.setBackgroundResource(if (on) R.drawable.bg_size_selected else R.drawable.bg_size)
                    s.setTextColor(if (on) Color.WHITE else getColor(R.color.gs_size_text))
                }
            }
        }

        findViewById<View>(R.id.btnAddToCart).setOnClickListener {
            Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show()
        }
    }
}