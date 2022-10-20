package com.example.reto.Clases

import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.example.reto.R


// menu personalizado
open class OptionsMenuActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        val inflador = menuInflater
        return true
    }

}