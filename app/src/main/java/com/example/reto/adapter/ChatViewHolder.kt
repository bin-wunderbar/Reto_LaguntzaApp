package com.example.reto.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.reto.databinding.ItemChatBinding
import com.example.reto.modelo.UsuariosChat

class ChatViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemChatBinding.bind(view)

    fun bind(chat: UsuariosChat) {
        binding.usuarioTxt.text = chat.usuario
        binding.lastChatTxt.text = chat.mensaje
        binding.fechaTxt.text = chat.fecha
        binding.numeroMensaje.text = chat.numero.toString()
        Glide.with(binding.fotoimg.context).load(chat.photo).into(binding.fotoimg)
    }
}