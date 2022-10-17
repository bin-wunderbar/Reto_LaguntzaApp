package com.example.reto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reto.adapter.RvAdapterChat
import com.example.reto.databinding.ActivityListaChatBinding
import com.example.reto.modelo.ChatProvider

class ListaChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListaChatBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // carga los datos obtenidos de viewholder
        iniciarRecyclerView()

        // button provesional para navigar entre activitys
        binding.back.setOnClickListener {
           finish()
        }

        // menu navigation desplegable
        cargarNavigationMenu()

    }

    //implementar la seguiente funcion en cada activity para mostrar publi
    override fun onResume() {
        super.onResume()
        // llama a la activity publicidad cada minuto
        activarPublicidad(this)
    }

    private fun iniciarRecyclerView(){
        binding.rvListChat.layoutManager=LinearLayoutManager(this)
        binding.rvListChat.adapter = RvAdapterChat(ChatProvider.listachat)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
    return super.onOptionsItemSelected(item)
    }
    // carga menu desplegable
    private fun cargarNavigationMenu() {
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navig.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.cat -> startActivity(intent)
                R.id.cat2 -> Toast.makeText(
                    applicationContext,
                    "is clicked item 2",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.cat3 -> Toast.makeText(
                    applicationContext,
                    "is clicked item 3",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.cat4 -> Toast.makeText(
                    applicationContext,
                    "is clicked item 4",
                    Toast.LENGTH_SHORT
                ).show()
            }
            true
        }

    }

}

