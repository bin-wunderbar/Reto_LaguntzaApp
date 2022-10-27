package com.example.reto.ui.ofertas


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reto.Clases.RetoApplication
import com.example.reto.Clases.RetoApplication.Companion.prefs
import com.example.reto.R
import com.example.reto.adapter.RvAdapterDemanda
import com.example.reto.adapter.RvAdapterOfertas
import com.example.reto.databinding.FragmentMisDemandasBinding
import com.example.reto.modelo.Ofertas
import com.google.firebase.firestore.FirebaseFirestore


class MisDemandasFragment : Fragment() {
    private var _binding: FragmentMisDemandasBinding? = null
    private val binding get() = _binding!!
    private lateinit var email : String
    private lateinit var adapter: RvAdapterDemanda
    private lateinit var recyclerview: RecyclerView
    private lateinit var OfertasList: ArrayList<Ofertas>
    private val db:FirebaseFirestore= FirebaseFirestore.getInstance()
    lateinit var  btnDelete: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMisDemandasBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        cargarDatos()
        aniadirDemanda()
        }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // carga datos de firebase
    private fun cargarDatos() {
        recyclerview = view?.findViewById(R.id.rvMisDemandas)!!
        val layoutManager = LinearLayoutManager(context)
        recyclerview.layoutManager = layoutManager
        recyclerview.setHasFixedSize(true)
        OfertasList = arrayListOf()
        email = prefs.getEmail()
        db.collection("ofertas")
            .whereEqualTo("usuario", email)
            .get()
            .addOnSuccessListener {
                if (!it.isEmpty) {
                    for (data in it.documents) {
                        val ofertas: Ofertas? = data.toObject(Ofertas::class.java)
                        if (ofertas != null) {
                            OfertasList.add(ofertas)
                        }
                    }
                    adapter = RvAdapterDemanda(OfertasList){
                        navigar(it)
                    }
                    recyclerview.adapter = adapter
                }
            }
    }

    private fun navigar(oferta: Ofertas) {
        val action = FavoresFragmentDirections.actionFavoresToEliminarOfertaFragment2(oferta)
        findNavController().navigate(action)
    }

    // lanza fragment añadir demanda nueva
    private fun aniadirDemanda(){
        binding.btnAddDemanda.setOnClickListener{
            val action = FavoresFragmentDirections.actionFavoresToAddDemandaFragment2()
            findNavController().navigate(action)
        }
    }



}