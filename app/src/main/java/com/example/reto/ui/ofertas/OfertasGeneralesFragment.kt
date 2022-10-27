package com.example.reto.ui.ofertas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isNotEmpty
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reto.Clases.RetoApplication.Companion.prefs
import com.example.reto.R
import com.example.reto.adapter.RvAdapterOfertas
import com.example.reto.databinding.ActivityAdminBinding.inflate
import com.example.reto.databinding.ActivityPublicidadBinding.inflate
import com.example.reto.databinding.FragmentOfertasGeneralesBinding
import com.example.reto.modelo.Ofertas
import com.google.firebase.firestore.FirebaseFirestore



class OfertasGeneralesFragment : Fragment() {

    private lateinit var adapter: RvAdapterOfertas
    private lateinit var recyclerview: RecyclerView
    lateinit var OfertasList: ArrayList<Ofertas>
    private lateinit var email : String
    private lateinit var asignar: Button
    private lateinit var miId : String


    private var _binding: FragmentOfertasGeneralesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentOfertasGeneralesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listarDatos()
    }

    // Listar las ofertas
    private fun listarDatos(){
        val layoutManager = LinearLayoutManager(context)
        recyclerview = view?.findViewById(R.id.rvOfertas)!!
        recyclerview.layoutManager = layoutManager
        recyclerview.setHasFixedSize(true)
        OfertasList = arrayListOf()
        email = prefs.getEmail()

        val db = FirebaseFirestore.getInstance()
        db.collection("ofertas")
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
                    adapter = RvAdapterOfertas(OfertasList){
                        navigar(it)
                    }
                    recyclerview.adapter = adapter
                }
            }
    }

    private fun navigar(oferta: Ofertas) {
        val action= FavoresFragmentDirections.actionFavoresToAsignarOfertaFragment2(oferta)
        findNavController().navigate(action)

    }

}