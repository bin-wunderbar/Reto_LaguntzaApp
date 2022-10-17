package com.example.reto

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reto.databinding.ActivityPerfilBinding
import com.google.firebase.firestore.FieldValue.delete
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source

class Perfil_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityPerfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cargarperfil()

        binding.btneditardatos.setOnClickListener {
            startActivity(Intent(this, Data_change_Activity::class.java))
        }
        binding.btnFavores.setOnClickListener {
            startActivity(Intent(this, ListaOfertasActivity::class.java))
        }
        binding.btnChat.setOnClickListener {
            startActivity(Intent(this, ListaChatActivity::class.java))
        }

        // llama a la activity publicidad cada minuto
        activarPublicidad(this)

    }

    override fun onResume() {
        super.onResume()
        cargarperfil()
        // llama a la activity publicidad cada minuto
        activarPublicidad(this)
    }



    fun cargarperfil(){
        val sharedPreferences: SharedPreferences = getSharedPreferences("Currentuser",0)
        var currentuser = sharedPreferences.getString("CurrentUser","Usuario")?.toString()
        val db = FirebaseFirestore.getInstance()
        db.collection("Usuarios")
            .whereEqualTo("email","${currentuser}")
            .get()
            .addOnSuccessListener { resultado ->
                val usuario = resultado.documents.get(0)
                val nombre = usuario.get("nombre")
                val apellidos = usuario.get("apellidos")
                val saldo = usuario.get("saldo")
                val descripcion = usuario.get("descripcion")
                val localidad = usuario.get("localidad")
                val id = usuario.get("id")
                sharedPreferences.edit().putString("Userid",id.toString()).apply()
                binding.txtCiudad.setText("${localidad}")
                binding.txtHoras.setText("${saldo}" + "h")
                binding.txtnombre.setText("${nombre}")
                binding.txtapellidos.setText("${apellidos}")
                binding.txtdescrip.setText("${descripcion}")





            }



    }
}