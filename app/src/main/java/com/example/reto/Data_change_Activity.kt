package com.example.reto

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.reto.databinding.ActivityDataChangeBinding
import com.example.reto.databinding.ActivityPerfilBinding
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.EmailAuthProvider.getCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

class Data_change_Activity : AppCompatActivity() {



    private lateinit var binding: ActivityDataChangeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_change)
        binding = ActivityDataChangeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btncambiarciudad.setOnClickListener {
            val sharedPreferences: SharedPreferences = getSharedPreferences("Currentuser",0)
            var currentuser = sharedPreferences.getString("CurrentUser","Usuario").toString()
            var id = getid(currentuser)
            if(binding.txtnuevaciudad.text.isNotEmpty()){
                val nuevaciudad = binding.txtnuevaciudad.text.toString()


                updatedata("localidad",nuevaciudad,id)
            }
            else{
                avisos("Error","Error Rellena el campo de actualizar ciudad")
            }

        }
        binding.btndescripcion.setOnClickListener{
            val sharedPreferences: SharedPreferences = getSharedPreferences("Currentuser",0)
            var currentuser = sharedPreferences.getString("CurrentUser","Usuario").toString()
            var id = getid(currentuser)
        if(binding.txtdescripcion.text.isNotEmpty()){
            val nuevadescripcion = binding.txtdescripcion.text.toString()
            updatedata("descripcion",nuevadescripcion,id)

        }
        else{
            avisos("Error","Error Rellena el campo de actualizar descripcion")
        }

        }
        binding.btncambiarpass.setOnClickListener{
            if(binding.txtpassAct.text.isNotEmpty() && binding.txtnuevapass.text.isNotEmpty()){
                val pass = binding.txtpassAct.text.toString()
                val nuevapass = binding.txtnuevapass.text.toString()
                val user = FirebaseAuth.getInstance().currentUser


                user!!.updatePassword(nuevapass).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val sharedPreferences: SharedPreferences = getSharedPreferences("Currentuser",0)
                        var currentuser = sharedPreferences.getString("CurrentUser","Usuario").toString()
                        var id = getid(currentuser)
                        updatedata("pass",nuevapass,id)

                    } else {
                        avisos("error","Error al cambiar de contraseña")
                    }
                }



            }else {
                avisos("error","Error Campos vacios")
            }


        }

    }


    private fun updatedata(campo:String,dat:String,User:String){
        val db = FirebaseFirestore.getInstance()
        println("${User}")
        db.collection("Usuarios")
            .document("${User}")
            .update("${campo}", "${dat}")

            .addOnSuccessListener {
                avisos("Exito","${campo} cambiada con exito")

            }
            .addOnFailureListener(){
                avisos("Error","Error al actualizar la ${campo}")

            }


    }
    private fun avisos(titulo:String,mensaje:String){
        //alertas
        val builder = AlertDialog.Builder(this)
        builder.setTitle("${titulo}")
        builder.setMessage("${mensaje}")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun getid(user:String):String{
        var id :String=""
        println("${user}" + "GETID")
        val sharedPreferences: SharedPreferences = getSharedPreferences("Currentuser",0)
        id = sharedPreferences.getString("Userid","0").toString()
        return id
    }
}