package com.example.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.items_list)
        val items = arrayListOf<Item>()
        val btn: Button = findViewById(R.id.button_bookshop)

        items.add(Item(1, "one", "Зимняя куртка", "Теплая куртка на синтепоне", "Капюшон, карманы на молнии", 450))
        items.add(Item(2, "two", "Демисезонное пальто", "Классическое пальто для весны", "Шерсть, приталенный крой", 600))
        items.add(Item(3, "three", "Плащ", "Защита от дождя и ветра", "Светлый цвет, легкий материал", 300))
        items.add(Item(4, "four", "Бомбер", "Защита от дождя и ветра", "Светлый цвет, легкий материал", 600))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)

        btn.setOnClickListener {
            val intent = Intent(this, BookshopActivity::class.java)
            startActivity(intent)
        }
    }
}