
package com.example.reto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reto.adapter.RvAdapterOfertas
import com.example.reto.databinding.ActivityListaOfertasBinding
import com.example.reto.modelo.Ofertas

class ListaOfertasActivity : AppCompatActivity() {
    lateinit private var binding: ActivityListaOfertasBinding
    lateinit var listaOfertas :List<Ofertas>
    lateinit private var rv: RvAdapterOfertas


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaOfertasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cargarDatos()


        rv = RvAdapterOfertas(listaOfertas)
        binding.rvOfertas.adapter = rv
    }
    fun cargarDatos(){
        listaOfertas = listOf(
            Ofertas("Modanzas", "lorem Ipsum caption et justo eiusmod tempor incididunt ut lab","Sestao",10),
            Ofertas("Cuidado mayores", "lorem Ipsum caption et justo eiusmod tempor incididunt ut lab","Sestao",10),
            Ofertas("Lunch comidas", "lorem Ipsum caption et justo eiusmod tempor incididunt ut lab","Sestao",10),
            Ofertas("Pintar salon", "lorem Ipsum caption et justo eiusmod tempor incididunt ut lab","Sestao",10),
            Ofertas("Lorem Ipsom", "lorem Ipsum caption et justo eiusmod tempor incididunt ut lab","Sestao",10),
        )
    }

}