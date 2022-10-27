package com.example.reto

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.reto.Clases.RetoApplication.Companion.prefs
import com.example.reto.databinding.ActivityLoginBinding
import com.example.reto.ui.main.Prencipal
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
    // Desactivar el button atras
    override fun onBackPressed() {
        Toast.makeText(this, "Acceso denegado", Toast.LENGTH_SHORT).show()
    }

    fun login(){
        //funcion de login
        if(binding.txtemail.text.isNotEmpty() && binding.txtpass.text.isNotEmpty()){
        val email = binding.txtemail.text.toString()
        val pass = binding.txtpass.text.toString()
            //autenticar el login
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass).addOnCompleteListener {
                if(it.isSuccessful){
                    //login exitoso
                    loginexitoso(email)
                }
                else {
                    //login fallido
                    aviso("Error", "Usuario o contraseña incorrectos")
                }
            }
        }
        else{
            //campos vacios
            aviso("Error", "Campos vacios")
        }
    }

    private fun loginexitoso(email : String){
        if(email == "administrador@laguntzapp.euz"){
            //administrador
           startActivity(Intent(this, Admin_Activity::class.java))
        }
        else{
            /*Guarda en preferencias el email del usuario que ha iniciado sesion
            * lanza la activity usuario normal*/
            prefs.saveEmail(email)
            startActivity(Intent(this, Prencipal::class.java))
        }
    }

    //Alerta con dos parametros titulo de la alerta y mensaje de la alerta
    private fun aviso(titulo: String, mensaje: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(titulo)
        builder.setMessage(mensaje)
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}