package com.example.reto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reto.adapter.RvAdapterChat
import com.example.reto.databinding.ActivityListaChatBinding
import com.example.reto.modelo.ChatProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
            var intent = Intent(this, ListaOfertasActivity::class.java)
            startActivity(intent)
        }


        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navig.setNavigationItemSelectedListener{menuItem->

            when(menuItem.itemId) {
                R.id.cat-> {
                    startActivity(intent)
                    true
                }
                R.id.cat2-> {
                    Toast.makeText(applicationContext,"is clicked item 2", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.cat3-> {
                    Toast.makeText(applicationContext,"is clicked item 3", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.cat4-> {
                    Toast.makeText(applicationContext,"is clicked item 4", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }


        }

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



}

