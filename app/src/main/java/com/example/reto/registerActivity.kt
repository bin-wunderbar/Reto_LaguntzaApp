package com.example.reto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.appcompat.app.AlertDialog
import com.example.reto.databinding.ActivityRegisterBinding
import com.google.firebase.firestore.FirebaseFirestore

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.Query
import java.time.Instant.now
import java.time.LocalDate
import java.time.LocalDate.now
import java.time.YearMonth.now
import java.util.Date


class registerActivity : AppCompatActivity() {


    private lateinit var binding: ActivityRegisterBinding
    var numuser = 0
    var idusuario : Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        idusuario = generariduser()

        binding.buttonRegistrar.setOnClickListener(){
            userregister()

        }
    }
    fun userregister(){
        val terminos = binding.terminos.isChecked
        //registrar usuario nuevo
        if(binding.textNombre.text.isNotEmpty() && binding.textNombre.text.isNotEmpty() &&
            binding.textApellidos.text.isNotEmpty() && binding.textCorreoRegis.text.isNotEmpty()
            && binding.textLocalidad.text.isNotEmpty() && binding.textPasswordReg.text.isNotEmpty()&&
            binding.textPassRegConfirmar.text.isNotEmpty()){


            println(idusuario)
            val nombre = binding.textNombre.text.toString()
            val apellidos = binding.textApellidos.text.toString()
            val email = binding.textCorreoRegis.text.toString()
            val localidad = binding.textLocalidad.text.toString()
            val pass = binding.textPasswordReg.text.toString()
            val confpass = binding.textPassRegConfirmar.text.toString()
            val reportes = 0
            var saldo = 0
            var fecha = Date()
            var description = "Description"

            println("${pass} + ${confpass}" )

            val db = FirebaseFirestore.getInstance()
            // comprobar contraseñas iguales


            if(pass == confpass) {
                if(terminos == true){
                    //comprobar el numero de usuarios inferior a 100
                    if(idusuario<=100){
                        saldo = 1
                    }
                    val datos = hashMapOf(
                        "id" to idusuario,
                        "nombre" to nombre,
                        "apellidos" to apellidos,
                        "email" to email,
                        "localidad" to localidad,
                        "reportes" to reportes,
                        "saldo" to saldo,
                        "pass" to pass,
                        "fecha" to fecha,
                        "description" to description
                    )
                    println(datos)
                    FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(binding.textCorreoRegis.text.toString(),binding.textPasswordReg.text.toString())
                        .addOnCompleteListener(){
                            if(it.isSuccessful){
                                db.collection("Usuarios")
                                    .document(idusuario.toString())
                                    .set(datos)
                                    .addOnSuccessListener {
                                        //mensaje exito
                                        showMessage("Registrado con exito")
                                        // lleva a la actividad login
                                        startActivity(Intent(this, loginActivity::class.java))
                                        finish()
                                    }
                                    .addOnFailureListener{
                                        println("error bbdd")
                                        showMessage("Error al registrar,")
                                    }
                            }else showMessage("Error al registrar, intenta una contraseña fuerte")
                        }
                }else showMessage("Por favor acepta los terminos y condiciones de uso")
            }else showMessage("Error las contraseñas no cinciden")
        }else showMessage("Por favor rellene todos los campos")
    }

    private fun generariduser():Int{
        var cod :String
        val db = FirebaseFirestore.getInstance()
        db.collection("Usuarios")
            //ordenar por desceniente limite de 1 haciendo q solo coja el mas grande
            .orderBy("id", Query.Direction.DESCENDING).limit(1)
            .get()
            .addOnSuccessListener { docs->
                var dato = ""
                for  (documento in docs){

                    dato += "${documento.get("id")}\n"


                    cod = dato.get(0).toString()

                    println("preuba numero " + cod)
                    idusuario = cod.toInt()

                }
                idusuario += 1
            }
            .addOnFailureListener(){
                println("fallo")
            }
        return idusuario
    }
    private fun showMessage(mensaje: String){
        //alerta de campos vacios
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage(mensaje)
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}

