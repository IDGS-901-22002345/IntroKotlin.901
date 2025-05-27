package com.example.introkotlin901.diccionario

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin901.R
import java.io.IOException
import java.io.OutputStreamWriter

class agregarPalabra : AppCompatActivity() {

    private val fileName = "diccionario.txt"

    private lateinit var editTextSpanish: EditText
    private lateinit var editTextEnglish: EditText
    private lateinit var buttonSave: Button
    private lateinit var textViewSaveMessage: TextView
    private lateinit var buttonReturnToMenu: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agregar_palabra)

        editTextSpanish = findViewById(R.id.editTextSpanish)
        editTextEnglish = findViewById(R.id.editTextEnglish)
        buttonSave = findViewById(R.id.buttonSave)
        textViewSaveMessage = findViewById(R.id.textViewSaveMessage)
        buttonReturnToMenu = findViewById(R.id.buttonReturnToMenu)


        buttonSave.setOnClickListener {
            saveWord()
        }

        buttonReturnToMenu.setOnClickListener {
            navigateToMenu()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun saveWord() {
        val spanishWord = editTextSpanish.text.toString().trim()
        val englishWord = editTextEnglish.text.toString().trim()

        if (spanishWord.isEmpty() || englishWord.isEmpty()) {
            textViewSaveMessage.text = "Error: Ambos campos deben ser llenados."
            textViewSaveMessage.visibility = TextView.VISIBLE
             textViewSaveMessage.setTextColor(resources.getColor(android.R.color.holo_red_dark))
            return
        }

        val wordEntry = "$spanishWord:$englishWord\n"

        try {

            openFileOutput(fileName, Context.MODE_APPEND).use { outputStream ->
                OutputStreamWriter(outputStream).use { writer ->
                    writer.write(wordEntry)
                }
            }
            editTextSpanish.text.clear()
            editTextEnglish.text.clear()

            textViewSaveMessage.text = "Palabra guardada con éxito."
            textViewSaveMessage.visibility = TextView.VISIBLE
            textViewSaveMessage.setTextColor(resources.getColor(android.R.color.holo_green_dark))

            textViewSaveMessage.postDelayed({
                textViewSaveMessage.visibility = TextView.INVISIBLE
            }, 3000)

        } catch (e: IOException) {
            e.printStackTrace()
            textViewSaveMessage.text = "Error al guardar la palabra: ${e.message}"
            textViewSaveMessage.visibility = TextView.VISIBLE
            textViewSaveMessage.setTextColor(resources.getColor(android.R.color.holo_red_dark))
        }
    }


    private fun navigateToMenu() {
        val intent = Intent(this, menuDiccionario::class.java)
        startActivity(intent)
        finish()
    }
}