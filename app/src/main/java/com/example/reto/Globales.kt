package com.example.reto

import android.content.Intent
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

var llamado: Boolean = false
fun permeterPublicidad(){
    llamado = false
    Log.i("activarPublicidad", "permeterPublicidad ")

}
// se le pasa una actividad donde espera cierto tiempo establishedy se lanza la actividad Publicidad
fun activarPublicidad(actividad: AppCompatActivity) {
    Log.i("activarPublicidad", "intento "+actividad.javaClass.simpleName)

    if(!llamado){
        llamado =true

        Log.i("activarPublicidad", "hilo "+actividad.javaClass.simpleName)
        actividad.lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                // comprueba si la actividad esta a la vista se inicia el contador
                if (!actividad.isFinishing){
                    // tiempo en el que espera para mostrar publicidad cada vez
                    for (i in 5 downTo 1) {
                        Thread.sleep(1000)
                    }
                }
            }
            actividad.startActivity(Intent(actividad, Publicidad::class.java))

        }
    }

}

