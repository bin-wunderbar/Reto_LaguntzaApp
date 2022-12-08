package com.example.reto.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reto.R
import com.example.reto.adapter.RvAdapterChat
import com.example.reto.modelo.ChatProvider
import com.example.reto.modelo.UsuariosChat


class ChatFragment : Fragment(R.layout.fragment_chat) {

   private lateinit var recyclerview: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cargarDatos()

    }

    private fun onChatClick(chat: UsuariosChat){
        val action = ChatFragmentDirections.actionChatFragmentToDetailsChatFragment(chat)
        findNavController().navigate(action)
    }
    private fun cargarDatos(){
        val layoutManager = LinearLayoutManager(context)
        recyclerview = view?.findViewById(R.id.rvListChat)!!
        recyclerview.layoutManager = layoutManager
        recyclerview.setHasFixedSize(true)
        recyclerview.adapter =  RvAdapterChat(ChatProvider.listachat){
            onChatClick(it)
        }
    }
}