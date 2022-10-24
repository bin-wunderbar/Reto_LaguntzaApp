package com.example.reto

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.reto.databinding.ActivityLoginBinding
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
            //autenticar el login
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass).addOnCompleteListener {
                if(it.isSuccessful){
                    //login exitoso
                    loginexitoso(email)
                }
                else {
                    //login fallido
                    errorlogin()
                }
            }
        }
        else{
            //campos vacios
            camposvacios()
        }



    }
    private fun errorlogin(){
        //alerta de usuario incorrecto
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Usuario o contraseña incorrectos")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun loginexitoso(email : String){

        if(email == "administrador@laguntzapp.euz"){
            //administrador
            startActivity(Intent(this, Admin_Activity::class.java))
        }
        else{
            // usuario normal
            currentuser()
            startActivity(Intent(this, Prencipal::class.java))
        }

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
    private fun currentuser(){
        val sharedPreferences: SharedPreferences = getSharedPreferences("Currentuser",0)
        sharedPreferences.edit().putString("CurrentUser",binding.txtemail.text.toString()).apply()
    }
}