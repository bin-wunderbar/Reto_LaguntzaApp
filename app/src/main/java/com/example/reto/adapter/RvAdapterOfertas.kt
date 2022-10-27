package com.example.reto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reto.R
import com.example.reto.modelo.Ofertas

class RvAdapterOfertas (private var ofertasList: List<Ofertas>): RecyclerView.Adapter<OfertasViewHolder>(){
    /*
    fun setData(list: List<Ofertas>){
        ofertasList = list
        notifyDataSetChanged()
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfertasViewHolder {
        val view= LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_ofertas_generales, parent, false)
        return OfertasViewHolder(view)
    }

    override fun onBindViewHolder(holder: OfertasViewHolder, position: Int) {
        holder.bind(ofertasList[position])
    }

    override fun getItemCount(): Int = ofertasList.size




}

