package com.example.reto.ui.ofertas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.reto.R
import com.example.reto.databinding.FragmentEditPerfilBinding
import com.example.reto.databinding.FragmentEliminarOfertaBinding
import com.example.reto.databinding.FragmentHomeBinding
import com.example.reto.ui.home.EditPerfilFragmentArgs
import com.google.firebase.firestore.FirebaseFirestore


class EliminarOfertaFragment : Fragment() {

    private var _binding : FragmentEliminarOfertaBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<EliminarOfertaFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, avedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEliminarOfertaBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        asignarCampos()
        eliminarOferta()

    }

    // asignar texto a los campos
    private  fun asignarCampos(){
        binding.estado.text = args.oferta.asignada.toString()
        binding.nameTxt.text = args.oferta.name.toString()
        binding.txtFecha.text = args.oferta.publicada.toString()
        binding.usuarioPublica.text = args.oferta.from.toString()
        binding.ubicacionTxt.text = args.oferta.ubicacion.toString()
        binding.descriptionTxt.text = args.oferta.descripcion.toString()
    }

    // Eliminar oferta si no esta asignada a ningun usuario
    private fun eliminarOferta(){
        binding.btnEliminar.setOnClickListener {
            if (args.oferta.asignada.toString()=="false"){
                val db = FirebaseFirestore.getInstance()
                db.collection("ofertas").document(args.oferta.id.toString()).delete()
                    .addOnSuccessListener {
                        Toast.makeText(binding.nameTxt.context, args.oferta.id.toString(), Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener(){
                        Toast.makeText(binding.nameTxt.context, "fallo "+args.oferta.id.toString(), Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }


    

}