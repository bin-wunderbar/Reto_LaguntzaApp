package com.example.reto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reto.R
import com.example.reto.modelo.Ofertas

class RvAdapterDemanda (var ofertasList: List<Ofertas>,private val escuchador:(Ofertas )-> Unit): RecyclerView.Adapter<DemandasViewHolder>(){
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
        holder.itemView.setOnClickListener {
            escuchador(ofertasList[position])
        }
    }

    override fun getItemCount(): Int = ofertasList.size




}
