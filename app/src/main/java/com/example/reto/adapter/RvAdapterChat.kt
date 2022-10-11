package com.example.reto.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reto.R
import com.example.reto.databinding.SingleItemssBinding
import com.example.reto.modelo.UsuariosChat

class RvAdapterChat(var listaChat: List<UsuariosChat>) :RecyclerView.Adapter<RvAdapterChat.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.single_itemss, parent, false
            )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listaChat[position])
    }

    override fun getItemCount(): Int { return listaChat.size }

    class ViewHolder (view: View) :RecyclerView.ViewHolder(view) {
        val binding = SingleItemssBinding.bind(view)
        fun bind(chat: UsuariosChat){

            binding.usuarioTxt.text       = chat.usuario
            binding.lastChatTxt.text      = chat.mensaje
            binding.fechaTxt.text         = chat.fecha
            binding.numeroMensaje.text    = chat.numero.toString()
        }


    }

}