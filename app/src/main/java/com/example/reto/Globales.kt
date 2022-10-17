package com.example.reto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.reto.Publicidad

fun activarPublicidad(actividad: AppCompatActivity) {

    actividad.lifecycleScope.launch {
        withContext(Dispatchers.IO) {
            // comprueba si la actividad esta a la vista se inicia el contador
            if (!actividad.isFinishing){
                // tiempo en el que espera para mostrar publicidad cada vez
                for (i in 60 downTo 1) {
                    Thread.sleep(1000)
                }
            }
        }
        actividad.startActivity(Intent(actividad, Publicidad::class.java))

    }
}