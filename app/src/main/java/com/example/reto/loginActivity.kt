package com.example.reto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.reto.databinding.ActivityLoginBinding
import com.example.reto.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

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
        binding.buttonlogin.setOnClickListener{
            login()


        }
    }

    fun login(){
        //funcion de login
        if(binding.txtemail.text.isNotEmpty() && binding.txtpass.text.isNotEmpty()){
        val email = binding.txtemail.text.toString()
        val pass = binding.txtpass.text.toString()
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass).addOnCompleteListener {
                if(it.isSuccessful){
                    loginexitoso()

                }
                else {
                    errorlogin()
                }


            }


        }
        else{
            camposvacios()

        }



    }
    private fun errorlogin(){
        //alerta de usuario incorrecto
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Error Usuario o contraseña incorrectos")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun loginexitoso(){
        //alerta temporal
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("login exitoso")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun camposvacios(){
        //alerta de campos vacios
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("error rellene los campos")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}