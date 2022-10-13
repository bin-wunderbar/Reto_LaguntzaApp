package com.example.reto.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reto.R
import com.example.reto.databinding.ItemChatBinding
import com.example.reto.modelo.UsuariosChat

class RvAdapterChat(var listaChat: List<UsuariosChat>) :RecyclerView.Adapter<ChatViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view= LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.item_chat, parent, false
            )
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(listaChat[position])
    }

    override fun getItemCount(): Int = listaChat.size




}

