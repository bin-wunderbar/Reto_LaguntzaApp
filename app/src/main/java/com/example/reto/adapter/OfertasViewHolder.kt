package com.example.reto.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.reto.databinding.ItemOfertasGeneralesBinding
import com.example.reto.modelo.Ofertas
import java.text.SimpleDateFormat

class OfertasViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemOfertasGeneralesBinding.bind(view)
    fun bind(oferta: Ofertas) {

        val simpleDate = SimpleDateFormat("dd/MM/yyyy HH:mm")
        val currentDate = simpleDate.format(oferta.publicada)

        binding.nameTxt.text        = oferta.name.toString()
        binding.descriptionTxt.text = oferta.descripcion.toString()
        binding.ubicacionTxt.text   = oferta.ubicacion.toString()
        binding.usuarioPublica.text = oferta.usuario.toString()
        binding.txtFecha.text =  currentDate
        if(oferta.asignada == true){
            binding.estado.text = oferta.from.toString()
            binding.button.isActivated=false
        }else{binding.estado.text = "Sin asignar"}


        // al dar click sobre la carta muestra mensaje con nombre de la carta
        itemView.setOnClickListener{
            //Toast.makeText(binding.nameTxt.context, oferta.nombre, Toast.LENGTH_SHORT).show()
        }
    }
}