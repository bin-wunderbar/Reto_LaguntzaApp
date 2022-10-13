package com.example.reto.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.reto.databinding.ItemFavoresBinding
import com.example.reto.modelo.Ofertas

class OfertasViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemFavoresBinding.bind(view)
    fun bind(oferta: Ofertas) {

        binding.nameTxt.text = oferta.name
        binding.descriptionTxt.text = oferta.description
        binding.ubicacionTxt.text = oferta.ubicacion
        binding.caducidadTxt.text = oferta.caducidad.toString()
    }
}