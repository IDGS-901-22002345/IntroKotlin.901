package com.example.introkotlin901.cinepolis

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin901.R
import android.widget.*
import java.text.DecimalFormat

class cinepolis : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtCompradores = findViewById<EditText>(R.id.edtCompradores)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val edtBoletos = findViewById<EditText>(R.id.edtBoletos)
        val txtTotal = findViewById<TextView>(R.id.txtTotal)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            if (edtCompradores.text.toString().isEmpty() || edtBoletos.text.toString().isEmpty()) {
                Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val compradores = edtCompradores.text.toString().toInt()
            val boletos = edtBoletos.text.toString().toInt()
            val precioUnitario = 12.0
            val formatter = DecimalFormat("$#,##0.00")

            if (boletos > compradores * 7) {
                Toast.makeText(this, "No se pueden comprar más de 7 boletos por persona", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val subtotal = boletos * precioUnitario
            var total = subtotal

            when {
                boletos > 5 -> total -= subtotal * 0.15
                boletos in 3..5 -> total -= subtotal * 0.10
            }

            val tieneTarjeta = radioGroup.checkedRadioButtonId == R.id.radioSi
            if (tieneTarjeta) {
                total -= total * 0.10
            }

            txtTotal.text = formatter.format(total)
        }
    }
}