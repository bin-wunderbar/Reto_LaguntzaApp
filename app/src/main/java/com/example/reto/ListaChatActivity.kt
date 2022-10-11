package com.example.reto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.reto.adapter.RvAdapterChat
import com.example.reto.databinding.ActivityListaChatBinding
import com.example.reto.modelo.UsuariosChat

class ListaChatActivity : AppCompatActivity() {
    lateinit private var binding: ActivityListaChatBinding
    lateinit var listachat :List<UsuariosChat>
    lateinit private var rv: RvAdapterChat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set the toolbar to the activity's toolbar
        setSupportActionBar(binding.toolbar)


        cargarDatos()


        rv = RvAdapterChat(listachat)
        binding.rvListChat.adapter= rv
    }
    // inflar el menu, añade items a la action bar si ello existe
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        getMenuInflater().inflate(R.menu.menu_chat, menu)
        return true
    }

    fun cargarDatos(){
        listachat = listOf(
            UsuariosChat("Alexander","Hello dear","30/09",2),
            UsuariosChat("Alexander","Hola, estas libre","01/10",50),
            UsuariosChat("Alexander","El plan de la tarde sigue en pie","08/10",4),
            UsuariosChat("Alexander","Genial","08/10",7),
            UsuariosChat("Alexander","Llamame cuando puedas","09/10",3),
            UsuariosChat("Alexander","lorem lapsom","10/10",1),
        )
    }

}