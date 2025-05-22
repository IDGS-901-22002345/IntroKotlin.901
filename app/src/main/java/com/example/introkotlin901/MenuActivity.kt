package com.example.introkotlin901

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin901.ejemplo1.SumaActivity
import com.example.introkotlin901.cinepolis.cinepolis
import com.example.introkotlin901.ejemplo2.saludoActivity


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnSuma = findViewById<Button>(R.id.btn1)
        val btnCine = findViewById<Button>(R.id.btn2)
        val btnSaludo = findViewById<Button>(R.id.btn3)


        btnSuma.setOnClickListener { navegateToSuma() }
        btnCine.setOnClickListener { navegateToCine() }
        btnSaludo.setOnClickListener { navegateToSaludar() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navegateToSuma () {
        val intent = Intent(this, SumaActivity::class.java)
        startActivities(arrayOf(intent))
    }
    private fun navegateToCine () {
        val intent = Intent(this, cinepolis::class.java)
        startActivities(arrayOf(intent))
    }
    private fun navegateToSaludar () {
        val intent = Intent(this, saludoActivity::class.java)
        startActivities(arrayOf(intent))
    }
}