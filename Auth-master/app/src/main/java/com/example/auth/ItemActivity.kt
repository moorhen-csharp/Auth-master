package com.example.auth

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_item)

        val title: TextView = findViewById(R.id.item_list_title_one)
        val text: TextView = findViewById(R.id.item_list_text)
        val image: ImageView = findViewById(R.id.item_list_image)
        val price: TextView = findViewById(R.id.item_list_price)
        val btn: Button = findViewById(R.id.button_buy)

        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")

        val imageName = intent.getStringExtra("itemImage")
        if (imageName != null) {
            val imageId = resources.getIdentifier(imageName, "drawable", packageName)
            image.setImageResource(imageId)
        }

        val itemPrice = intent.getIntExtra("itemPrice", 0)
        price.text = "$itemPrice₽"

        btn.setOnClickListener {
            val title = intent.getStringExtra("itemTitle") ?: ""
            val desc = intent.getStringExtra("itemText") ?: ""
            val image = intent.getStringExtra("itemImage") ?: ""
            val price = intent.getIntExtra("itemPrice", 0)

            val item = Item(0, image, title, desc, "", price) // заполняем модель
            CartManager.addItem(item)

            Toast.makeText(this, "Товар добавлен в корзину", Toast.LENGTH_SHORT).show()
        }
    }
}