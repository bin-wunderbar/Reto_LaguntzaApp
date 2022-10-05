package com.example.reto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.TextView

import androidx.lifecycle.lifecycleScope

import com.example.reto.databinding.ActivityPublicidadBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class Publicidad : AppCompatActivity() {

    private lateinit var  binding: ActivityPublicidadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPublicidadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // button saltar  desactivado por defecto
        binding.cardButtonSaltar.isEnabled = false

        // on click open main activity
        binding.cardButtonSaltar.setOnClickListener {
           // val intent = Intent(this,MainActivity::class.java)
           // startActivity(intent)
        }


    }

    override fun onResume() {
        super.onResume()
        // desactivar button saltar por defecto
        binding.cardButtonSaltar.isEnabled = false

        lifecycleScope.launch{
            withContext(Dispatchers.IO) {
                for (i in 5 downTo 1){
                    binding.txtContador.setText("Saltar publicidad en ${i}")
                    Thread.sleep(1000)
                }
            }
            binding.cardButtonSaltar.isEnabled = true
            binding.txtContador.setText("")
        }


    }
    //implementar la seguiente funcion en cada activity para mostrar publi
    /*override fun onResume() {
    super.onResume()
    activarPublicidad()
}
fun activarPublicidad(){
    lifecycleScope.launch{
        withContext(Dispatchers.IO) {
        // tiempo en el que espera para mostrar publicidad cada vez
            for (i in 60 downTo 1){
                Thread.sleep(1000)
            }
        }
        val intent = Intent(this@MainActivity,Publicidad::class.java)
        startActivity(intent)
    }
}*/

}