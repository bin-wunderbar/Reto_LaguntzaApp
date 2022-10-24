package com.example.reto.ui.ofertas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reto.R
import com.example.reto.adapter.RvAdapterOfertas
import com.example.reto.modelo.OfertasProvider


class OfertasFragment : Fragment() {

   private lateinit var adapter: RvAdapterOfertas
   private lateinit var recyclerview: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ofertas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        recyclerview = view.findViewById(R.id.rvOfertas)
        recyclerview.layoutManager = layoutManager
        recyclerview.setHasFixedSize(true)
        adapter = RvAdapterOfertas(OfertasProvider.listaOfertas)
        recyclerview.adapter = adapter
    }


}