package com.example.reto.ui.ofertas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reto.Clases.RetoApplication
import com.example.reto.Clases.RetoApplication.Companion.prefs
import com.example.reto.R
import com.example.reto.adapter.RvAdapterOfertas
import com.example.reto.modelo.Ofertas
import com.google.firebase.firestore.FirebaseFirestore


class OfertasGeneralesFragment : Fragment() {

    private lateinit var adapter: RvAdapterOfertas
    private lateinit var recyclerview: RecyclerView
    lateinit var OfertasList: ArrayList<Ofertas>
    private lateinit var email : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ofertas_generales, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        recyclerview = view.findViewById(R.id.rvOfertas)
        recyclerview.layoutManager = layoutManager
        recyclerview.setHasFixedSize(true)
        OfertasList = arrayListOf()

        val db = FirebaseFirestore.getInstance()
        email = prefs.getEmail()
        db.collection("Favores")
            .whereNotEqualTo("usuario", email)
            .get()
            .addOnSuccessListener {
                if (!it.isEmpty) {
                    for (data in it.documents) {
                        val ofertas: Ofertas? = data.toObject(Ofertas::class.java)
                        if (ofertas != null) {
                            OfertasList.add(ofertas)
                        }
                    }
                    adapter = RvAdapterOfertas(OfertasList)
                    recyclerview.adapter = adapter
                }
            }
    }

}