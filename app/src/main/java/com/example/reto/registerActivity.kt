package com.example.reto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AlertDialog
import com.example.reto.databinding.ActivityRegisterBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.Query


class registerActivity : AppCompatActivity() {

    var numuser = 0
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
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

            var idusuario : Int = generariduser()
            idusuario++
            println(idusuario)
            val nombre = binding.textNombre.text.toString()
            val apellidos = binding.textApellidos.text.toString()
            val email = binding.textCorreoRegis.text.toString()
            val localidad = binding.textLocalidad.text.toString()
            val pass = binding.textPasswordReg.text.toString()
            val confpass = binding.textPassRegConfirmar.text.toString()
            val reportes = 0
            var saldo = 0

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
                        "pass" to pass
                        )
                        println(datos)
                        FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(binding.textCorreoRegis.text.toString(),binding.textPasswordReg.text.toString())
                        .addOnCompleteListener(){
                                if(it.isSuccessful){
                                    showpalertregistrobien()

                                        db.collection("Usuarios")
                                        .document(idusuario.toString())
                                        .set(datos)
                                        .addOnSuccessListener { resultado ->
                                        //mensaje exito
                                        showpalertregistrobien()
                                        }
                                        .addOnFailureListener{ Exception ->
                                        println("error bbdd")
                                        showpalertregistroerror()
                                        }


                                    }
                                else{
                                println("error autenticacion")
                                showpalertregistroerror()
                                }

                            }

                        }else{
                    showpalertterminos()

                    }

                    }else  {
                    //mensaje de error por contraseña no coincide
                    showpalerterrorpass()
                            }
            }
            else {
                //mensaje de campos vacios
                showpalertcampos()
            }




    }
    private fun generariduser(): Int {
        var cod :String=""
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

                }
                numuser = cod.toInt()
            }
            .addOnFailureListener(){
                println("fallo")

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
    private fun showpalertregistroerror(){
        //alerta de error de registro
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Error al registrar, la contraseña deve inclur mayus y minus y numeros")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun showpalertregistrobien(){
        //alerta de exito de registro
        val builder = AlertDialog.Builder(this)
        builder.setTitle("registrado")
        builder.setMessage("Registrado con exito")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()


    }
    private fun showpalerterrorpass(){
        //alerta de contraseña no coincide
        val builder = AlertDialog.Builder(this)
        builder.setTitle("error")
        builder.setMessage("Error las contraseñas no cinciden")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun showpalertterminos(){
        //alerta de terminso y coniciones
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Por favor acepta lso terminos y condiciones de uso")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}