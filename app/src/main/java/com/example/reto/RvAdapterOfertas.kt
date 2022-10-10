package com.example.reto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reto.databinding.ItemFavoresBinding

class RvAdapterOfertas(var listaOfertas: List<Ofertas>) :RecyclerView.Adapter<RvAdapterOfertas.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_favores, parent, false
            )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listaOfertas[position])
    }

    override fun getItemCount(): Int { return listaOfertas.size }

    class ViewHolder (view: View) :RecyclerView.ViewHolder(view) {
        val binding = ItemFavoresBinding.bind(view)
        fun bind(oferta:Ofertas){

            binding.nameTxt.text              = oferta.name
            binding.descriptionTxt.text       = oferta.description
            binding.ubicacionTxt.text         = oferta.ubicacion
            binding.caducidadTxt.text         = oferta.caducidad.toString()
        }


    }

}