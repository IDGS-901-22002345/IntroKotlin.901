package com.example.introkotlin901.diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin901.R
import com.example.introkotlin901.cinepolis.cinepolis
import com.example.introkotlin901.ejemplo1.SumaActivity

class menuDiccionario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_diccionario)

        val btnBuscaren = findViewById<Button>(R.id.buttonSearchWords)
        val btnCapturar = findViewById<Button>(R.id.buttonCaptureWords)

        btnCapturar.setOnClickListener { navegateToCapture() }
        btnBuscaren.setOnClickListener { navegateToSearch() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun navegateToCapture () {
        val intent = Intent(this, agregarPalabra::class.java)
        startActivities(arrayOf(intent))
    }
    private fun navegateToSearch () {
        val intent = Intent(this, diccionario::class.java)
        startActivities(arrayOf(intent))
    }
}