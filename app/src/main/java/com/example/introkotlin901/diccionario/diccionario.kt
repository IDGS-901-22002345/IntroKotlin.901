package com.example.introkotlin901.diccionario

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin901.R
import java.io.FileNotFoundException
import java.io.IOException

class diccionario : AppCompatActivity() {

    private val fileName = "diccionario.txt"

    private lateinit var radioGroupLanguage: RadioGroup
    private lateinit var radioButtonSpanish: RadioButton
    private lateinit var radioButtonEnglish: RadioButton
    private lateinit var editTextWordToSearch: EditText
    private lateinit var buttonSearch: Button
    private lateinit var textViewResultMessage: TextView
    private lateinit var textViewTranslatedWord: TextView
    private lateinit var buttonReturnToMenu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_diccionario)

        radioGroupLanguage = findViewById(R.id.radioGroupLanguage)
        radioButtonSpanish = findViewById(R.id.radioButtonSpanish)
        radioButtonEnglish = findViewById(R.id.radioButtonEnglish)
        editTextWordToSearch = findViewById(R.id.editTextWordToSearch)
        buttonSearch = findViewById(R.id.buttonSearch)
        textViewResultMessage = findViewById(R.id.textViewResultMessage)
        textViewTranslatedWord = findViewById(R.id.textViewTranslatedWord)
        buttonReturnToMenu = findViewById(R.id.buttonReturnToMenu)

        buttonSearch.setOnClickListener {
            searchWord()
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


    private fun navigateToMenu() {
        val intent = Intent(this, menuDiccionario::class.java)
        startActivity(intent)
        finish()
    }

    private fun searchWord() {
        val wordToFind = editTextWordToSearch.text.toString().trim()

        if (wordToFind.isEmpty()) {
            textViewResultMessage.text = "Por favor, ingresa una palabra para buscar."
            textViewResultMessage.visibility = TextView.VISIBLE
            textViewTranslatedWord.text = ""
            return
        }

        try {
            val fileContent = openFileInput(fileName).bufferedReader().useLines { lines ->
                lines.toList()
            }

            textViewResultMessage.visibility = TextView.INVISIBLE
            textViewTranslatedWord.text = ""

            var found = false
            var translatedWord = ""

            val searchFromSpanish = radioButtonSpanish.isChecked

            for (line in fileContent) {
                val parts = line.split(":")
                if (parts.size == 2) {
                    val spanish = parts[0].trim().lowercase()
                    val english = parts[1].trim().lowercase()

                    if (searchFromSpanish && spanish == wordToFind.lowercase()) {
                        translatedWord = english
                        found = true
                        break
                    } else if (!searchFromSpanish && english == wordToFind.lowercase()) {
                        translatedWord = spanish
                        found = true
                        break
                    }
                }
            }

            if (found) {
                textViewResultMessage.text = "Palabra encontrada:"
                textViewResultMessage.visibility = TextView.VISIBLE
                textViewTranslatedWord.text = translatedWord
            } else {
                textViewResultMessage.text = "Palabra no encontrada."
                textViewResultMessage.visibility = TextView.VISIBLE
                textViewTranslatedWord.text = ""
            }

        } catch (e: FileNotFoundException) {
            textViewResultMessage.text = "El diccionario está vacío. No hay palabras para buscar."
            textViewResultMessage.visibility = TextView.VISIBLE
            textViewTranslatedWord.text = ""
        } catch (e: IOException) {
            e.printStackTrace()
            textViewResultMessage.text = "Error al leer el diccionario: ${e.message}"
            textViewResultMessage.visibility = TextView.VISIBLE
            textViewTranslatedWord.text = ""
        }
    }
}