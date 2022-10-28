package com.example.reto.adapter

import android.view.View

import androidx.recyclerview.widget.RecyclerView
import com.example.reto.databinding.ItemMisDemandasBinding
import com.example.reto.modelo.Ofertas
import java.text.SimpleDateFormat

class DemandasViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemMisDemandasBinding.bind(view)
        fun bind(oferta: Ofertas) {

            val simpleDate  = SimpleDateFormat("dd/MM/yyyy HH:mm")
            val currentDate = simpleDate.format(oferta.publicada)


            binding.nameTxt.text        = oferta.name.toString()
            binding.descriptionTxt.text = oferta.descripcion.toString()
            binding.ubicacionTxt.text   = oferta.ubicacion.toString()
            binding.txtFecha.text       = currentDate
            binding.usuarioPublica.text = oferta.usuario.toString()
            if(oferta.asignada == true){
                binding.estado.text = oferta.from.toString()
            }else{binding.estado.text = "Sin asignar"}

        }
    }
