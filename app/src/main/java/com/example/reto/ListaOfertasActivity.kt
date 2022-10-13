
package com.example.reto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reto.adapter.RvAdapterOfertas
import com.example.reto.databinding.ActivityListaOfertasBinding
import com.example.reto.modelo.OfertasProvider


class ListaOfertasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListaOfertasBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaOfertasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // carga los datos obtenidos de viewholder
        iniciarRecyclerView()

        // button flotante provesional para navigar entre activitys
        binding.back.setOnClickListener {
            finish()
        }

        // llama a la activity publicidad cada minuto
        activarPublicidad(this)

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navig.setNavigationItemSelectedListener{
            when(it.itemId) {
                R.id.cat-> startActivity(intent)
                R.id.cat2-> Toast.makeText(applicationContext,"is clicked item 2", Toast.LENGTH_SHORT).show()
                R.id.cat3-> Toast.makeText(applicationContext,"is clicked item 3", Toast.LENGTH_SHORT).show()
                R.id.cat4-> Toast.makeText(applicationContext,"is clicked item 4", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    //implementar la seguiente funcion en cada activity para mostrar publi
    override fun onResume() {
        super.onResume()
        activarPublicidad(this)
    }

    private fun iniciarRecyclerView(){
        binding.rvOfertas.layoutManager = LinearLayoutManager(this)
        binding.rvOfertas.adapter = RvAdapterOfertas(OfertasProvider.listaOfertas)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}