package com.example.homework2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvNumber: TextView
    private lateinit var myListener: MyListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvNumber = findViewById(R.id.tvNumber)
        myListener = MyListener(tvNumber, this)

        val btnIds = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnClear, R.id.btnCall
        )

        btnIds.forEach { id ->
            findViewById<Button>(id).setOnClickListener(myListener)
        }
    }
}
