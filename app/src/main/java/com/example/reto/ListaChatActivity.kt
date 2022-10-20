package com.example.reto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
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

  /*      toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navig.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.cat-> Toast.makeText(applicationContext,"cat", Toast.LENGTH_SHORT).show()
                R.id.cat2-> Toast.makeText(applicationContext,"cat2", Toast.LENGTH_SHORT).show()
                R.id.cat3-> Toast.makeText(applicationContext,"cat3", Toast.LENGTH_SHORT).show()
                R.id.cat4-> Toast.makeText(applicationContext,"cat4", Toast.LENGTH_SHORT).show()

            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }*/

        // carga los datos obtenidos de viewholder
        //iniciarRecyclerView()

        // button provesional para navigar entre activitys
       /* binding.back.setOnClickListener {
           finish()
        }*/

        // menu navigation desplegable
       // cargarNavigationMenu()

    }


    // carga menu desplegable
    private fun cargarNavigationMenu() {


    }


    private fun iniciarRecyclerView(){
        binding.rvListChat.adapter = RvAdapterChat(ChatProvider.listachat)
    }


}

