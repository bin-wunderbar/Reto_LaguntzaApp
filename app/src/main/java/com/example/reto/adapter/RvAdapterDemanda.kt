package com.example.reto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reto.R
import com.example.reto.modelo.Ofertas

class RvAdapterDemanda (private var ofertasList: List<Ofertas>): RecyclerView.Adapter<DemandasViewHolder>(){
    /*
    fun setData(list: List<Ofertas>){
        ofertasList = list
        notifyDataSetChanged()
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemandasViewHolder {
        val view= LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_mis_demandas, parent, false)
        return DemandasViewHolder(view)
    }

    override fun onBindViewHolder(holder: DemandasViewHolder, position: Int) {
        holder.bind(ofertasList[position])
    }

    override fun getItemCount(): Int = ofertasList.size




}
