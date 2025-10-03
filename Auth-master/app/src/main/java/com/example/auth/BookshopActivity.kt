package com.example.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BookshopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bookshop)

        val recycler: RecyclerView = findViewById(R.id.cart_list)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = ItemsAdapter(CartManager.cartItems, this)

        val checkoutBtn: Button = findViewById(R.id.button_checkout)
        checkoutBtn.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }

    }
}