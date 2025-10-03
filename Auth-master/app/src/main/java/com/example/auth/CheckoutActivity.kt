package com.example.auth

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class CheckoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_checkout)

        val textTotal: TextView = findViewById(R.id.text_total_price)
        val spinnerCity: Spinner = findViewById(R.id.spinner_city)
        val buttonCalc: Button = findViewById(R.id.button_calculate)
        val textDesc: TextView = findViewById(R.id.text_description)

        // Города и расстояния от Санкт-Петербурга (км)
        val cityDistances = mapOf(
            "Санкт-Петербург" to 0,
            "Москва" to 700,
            "Сочи" to 2300,
            "Иркутск" to 5200
        )

        // Заполняем Spinner списком городов
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            cityDistances.keys.toList()
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCity.adapter = adapter

        // Получаем корзину
        val items = CartManager.cartItems
        val B = items.sumOf { it.price } // сумма товаров
        val p = 0.02                     // 2% страховка
        val C = 200                      // фиксированная доставка
        val k = 3                        // цена за км

        buttonCalc.setOnClickListener {
            val selectedCity = spinnerCity.selectedItem.toString()
            val d = cityDistances[selectedCity] ?: 0

            val P = B + (B * p) + C + (k * d)

            textTotal.text = "Цена заказа: ${P.toInt()} ₽\nГород доставки: $selectedCity"




            val insurance = B * p
            val delivery = C + (k * d)

            // Формируем подробный расчёт
            val summary = """
                Формула: P = B + (B × p) + C + k × d

                Подставляем:
                P = $B + ($B × $p) + $C + $k × $d
                P = $B + ${insurance.toInt()} + $C + ${k * d}

                ----------------------------
                Товары: $B ₽
                Страховка: ${insurance.toInt()} ₽
                Доставка: ${delivery.toInt()} ₽
                Расстояние: $d км
                ----------------------------
            """.trimIndent()
            textDesc.text = summary
        }
    }
}
