package com.example.reto

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.reto.databinding.ActivityPublicidadBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep


class Publicidad : AppCompatActivity() {

    private lateinit var binding: ActivityPublicidadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPublicidadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // button saltar  desactivado por defecto
        habilitarButton(false)

        // on click cierra la activity actual
        binding.btnsalir.setOnClickListener {
            permeterPublicidad()
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        // desactivar button saltar por defecto
        habilitarButton(false)
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                for (i in 3 downTo 1) {
                    sleep(1000)
                }
            }
            habilitarButton(true)
        }
    }

    fun habilitarButton(estado: Boolean) {
        binding.btnsalir.isVisible= estado
    }

}


