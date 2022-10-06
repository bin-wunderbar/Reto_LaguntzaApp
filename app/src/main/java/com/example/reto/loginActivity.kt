package com.example.reto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reto.databinding.ActivityLoginBinding
import com.example.reto.databinding.ActivityRegisterBinding

class loginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //abrir ventana de registro
        binding.buttonregister.setOnClickListener {
            startActivity(Intent(this, registerActivity::class.java))
        }

    }
}