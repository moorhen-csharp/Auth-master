package com.example.auth

object CartManager {
    val cartItems = mutableListOf<Item>()

    fun addItem(item: Item) {
        cartItems.add(item)
    }

    fun clear() {
        cartItems.clear()
    }
}
