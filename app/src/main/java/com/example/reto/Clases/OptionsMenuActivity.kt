package com.example.reto.Clases

import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.reto.ChatFragment
import com.example.reto.R


// menu personalizado
open class OptionsMenuActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        val inflador = menuInflater
        inflador.inflate(R.menu.menu_chat,menu)
        return true
    }

}