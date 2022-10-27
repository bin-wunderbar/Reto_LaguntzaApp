package com.example.reto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reto.R
import com.example.reto.modelo.Ofertas

class RvAdapterMisOfertas (private var ofertasList: List<Ofertas>): RecyclerView.Adapter<MisOfertasViewHolder>(){
    /*
    fun setData(list: List<Ofertas>){
        ofertasList = list
        notifyDataSetChanged()
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MisOfertasViewHolder {
        val view= LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_mis_ofertas, parent, false)
        return MisOfertasViewHolder(view)
    }

    override fun onBindViewHolder(holder: MisOfertasViewHolder, position: Int) {
        holder.bind(ofertasList[position])

    }

    override fun getItemCount(): Int = ofertasList.size




}
