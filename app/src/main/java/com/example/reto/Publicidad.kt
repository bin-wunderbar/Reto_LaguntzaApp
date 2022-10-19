package com.example.reto

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.reto.databinding.ActivityPublicidadBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep


@Suppress("BlockingMethodInNonBlockingContext")
class Publicidad : AppCompatActivity() {

    private lateinit var binding: ActivityPublicidadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPublicidadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // button saltar  desactivado por defecto
        binding.cardButtonSaltar.isEnabled = false

        // on click cierra la activity actual
        binding.cardButtonSaltar.setOnClickListener {
            finish()

        }
    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()
        // desactivar button saltar por defecto
        binding.cardButtonSaltar.isEnabled = false

        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                for (i in 5 downTo 1) {
                    binding.txtContador.text = "Saltar publicidad en $i"
                    sleep(1000)
                }
            }
            binding.cardButtonSaltar.isEnabled = true
            binding.txtContador.text = ""
        }
    }

}


