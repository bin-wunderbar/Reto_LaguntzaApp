package com.example.reto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.reto.ui.publicidad.Publicidad
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

var llamado: Boolean = false
fun permeterPublicidad(){
    llamado = false
}
// se le pasa una actividad donde espera cierto tiempo establishedy se lanza la actividad Publicidad
fun activarPublicidad(actividad: AppCompatActivity) {

    if(!llamado){
        llamado =true

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

}

