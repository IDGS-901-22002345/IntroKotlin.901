package com.example.introkotlin901.ejemplo1

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin901.R

class SumaActivity : AppCompatActivity() {
    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView
    private lateinit var radioSum: RadioButton
    private lateinit var radioResta: RadioButton
    private lateinit var radioDiv: RadioButton
    private lateinit var radioMulti: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_suma)

        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        tv1 = findViewById(R.id.tv1)
        radioSum = findViewById(R.id.radioSum)
        radioResta = findViewById(R.id.radioResta)
        radioDiv = findViewById(R.id.radioDiv)
        radioMulti = findViewById(R.id.radioMulti)

        radioSum.isChecked = true

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular(view: View) {
        val num1 = et1.text.toString().toDouble()
        val num2 = et2.text.toString().toDouble()
        val resultado: Double

        when {
            radioSum.isChecked -> {
                resultado = num1 + num2
                tv1.text = "Suma = $resultado"
            }
            radioResta.isChecked -> {
                resultado = num1 - num2
                tv1.text = "Resta = $resultado"
            }
            radioMulti.isChecked -> {
                resultado = num1 * num2
                tv1.text = "Multiplicación = $resultado"
            }
            radioDiv.isChecked -> {
                if (num2 != 0.0) {
                    resultado = num1 / num2
                    tv1.text = "División = $resultado"
                } else {
                    tv1.text = "No se puede dividir por cero"
                }
            }
        }
    }
}