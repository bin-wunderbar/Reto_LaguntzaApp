package com.example.reto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.reto.databinding.ActivityRegisterBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.*
import com.google.firebase.auth.FirebaseAuth


class registerActivity : AppCompatActivity() {
    var numuser = 0
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
    fun userregister(){
        //registrar usuario nuevo
        if(binding.textNombre.text.isNotEmpty() && binding.textNombre.text.isNotEmpty() &&
            binding.textApellidos.text.isNotEmpty() && binding.textCorreoRegis.text.isNotEmpty()
            && binding.textLocalidad.text.isNotEmpty() && binding.textPasswordReg.text.isNotEmpty()&&
                binding.textPassRegConfirmar.text.isNotEmpty()){

            var idusuario : Int = generariduser()
            val nombre = binding.textNombre.text.toString()
            val apellidos = binding.textApellidos.text.toString()
            val email = binding.textCorreoRegis.text.toString()
            val localidad = binding.textLocalidad.text.toString()
            val pass = binding.textPasswordReg.text.toString()
            val confpass = binding.textPassRegConfirmar.toString()
            val reportes = 0
            var saldo = 0
            val db = FirebaseFirestore.getInstance()
            // comprobar contraseñas iguales
            if(pass.equals(confpass)) {
                //comprobar el numero de usuarios inferior a 100
                if(numuser<=100){
                    saldo = 1
                }
                val datos = hashMapOf(
                    "id" to idusuario,
                    "nombre" to nombre,
                    "apellidos" to apellidos,
                    "email" to email,
                    "localidad" to localidad,
                    "reportes" to reportes,
                    "saldo" to saldo
                )
                FirebaseAuth.//terminar
                db.collection("Usuarios")
                    .document()
                    .set(datos)
                    .addOnSuccessListener { resultado ->
                    //mensaje exito
                    }
                    .addOnFailureListener{ Exception ->
                    //mensaje de error
                    }




            }
                else  {
                    //mensaje de error por contraseña no coincide
                }

            }
            else {
                //mensaje de campos vacios
                showpalertcampos()
            }




    }
    private fun generariduser(): Int {
        val db = FirebaseFirestore.getInstance()
        db.collection("cantidadusuarios")
            .get()
            .addOnSuccessListener { docs->
                var datos = ""
                for  (documento in docs){

                    datos += "${documento.data}\n"

                }
                numuser = datos.toInt()
            }
        return numuser
    }
    private fun showpalertcampos(){
        //alerta de campos vacios
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Te falta algun campo por rellenar")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }



}