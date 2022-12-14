package com.tarasov_denis.vkcup

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.View.generateViewId
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Space
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate


class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        val continueButton = findViewById<Button>(R.id.continueButton)

        val list = listOf("Еда", "Новости", "Спорт", "Отдых", "Юмор", "Политика", "Рецепты",
            "Рестораны", "Сериалы", "Прогулки", "Кино", "Автомобили", "Работа", "Еда", "Спорт",
            "Рестораны", "Отдых", "Кино", "Сериалы", "Прогулки", "Кино", "Автомобили",
            "Работа", "Еда", "Спорт", "Сериалы", "Прогулки")
        val listID = mutableListOf<Int>()

        val lists = mutableListOf( mutableListOf<String>())

        var num = 0
        var index = 0
        for (i in list) {
            if (index < 3) {
                lists[num].add(i)
                index++
            } else {
                lists.add(mutableListOf<String>())
                num++
                lists[num].add(i)
                index = 1
            }
        }

        val layout1 = findViewById<LinearLayout>(R.id.layout1)

        for (j in lists.indices) {
            val row = LinearLayout(this)
            row.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            for (i in lists[j]) {
                val button1 = Button(this)
                button1.id = generateViewId()
                button1.setBackgroundResource(R.drawable.button1)
                button1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.add_symbol, 0)
                listID.add(button1.id)

                button1.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    100)
                button1.text = i

                row.addView(button1)

                // добавляем пространство между кнопками
                val space1 = Space(this)
                space1.layoutParams = LinearLayout.LayoutParams(
                    20,
                    LinearLayout.LayoutParams.WRAP_CONTENT)
                row.addView(space1)

                var colorIsGreen = false

                button1.setOnClickListener {

                    continueButton.visibility = View.VISIBLE
                    if (colorIsGreen) {
                        button1.setBackgroundResource(R.drawable.button1)
                        button1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.add_symbol, 0)
                        colorIsGreen = false
                    } else {
                        button1.setBackgroundResource(R.drawable.button_selected)
                        button1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.selected_symbol, 0)
                        colorIsGreen = true
                    }
                }
        }
            layout1.addView(row)

            // добавляем пространство между строками кнопок
            val space = Space(this)
            space.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                20)
            layout1.addView(space)
        }
    }
}