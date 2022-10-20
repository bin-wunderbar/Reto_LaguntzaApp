package com.example.reto.ui.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reto.R
import com.example.reto.adapter.RvAdapterChat
import com.example.reto.modelo.ChatProvider


class ChatFragment : Fragment() {

   private lateinit var adapter: RvAdapterChat
   private lateinit var recyclerview: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        recyclerview = view.findViewById(R.id.rvListChat)
        recyclerview.layoutManager = layoutManager
        recyclerview.setHasFixedSize(true)
        adapter = RvAdapterChat(ChatProvider.listachat)
        recyclerview.adapter = adapter
    }

}