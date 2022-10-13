package com.example.reto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun activarPublicidad( actividad: AppCompatActivity) {
    actividad.lifecycleScope.launch {
        withContext(Dispatchers.IO) {
            // tiempo en el que espera para mostrar publicidad cada vez
            for (i in 90 downTo 1) {
                Thread.sleep(1000)
            }
        }
        val intent = Intent(actividad, Publicidad::class.java)
        actividad.startActivity(intent)
    }
}