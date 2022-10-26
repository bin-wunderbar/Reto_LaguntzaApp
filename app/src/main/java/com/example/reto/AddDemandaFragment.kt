package com.example.reto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.reto.Clases.Prefs
import com.example.reto.Clases.RetoApplication.Companion.prefs
import com.example.reto.databinding.FragmentAddDemandaBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*


class AddDemandaFragment : Fragment() {
    private var _binding: FragmentAddDemandaBinding? = null
    private val binding get() = _binding!!
    private lateinit var email : String




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddDemandaBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        email = prefs.getEmail()
        binding.btnPublicar.setOnClickListener{
            if (comprobarCampos()){
                val nombre       = binding.nameTxt.text.toString()
                val caducidad    = binding.caducidadTxt.text.toString()
                val description  = binding.descriptionTxt.text.toString()
                val ubicacion    = binding.ubicacionTxt.text.toString()
                val horas        = binding.txtCantidadHoras.text.toString()

                val db = FirebaseFirestore.getInstance()
                val demanda = hashMapOf(
                    "asignada" to false,
                    "publicada" to Date(),
                    "usuario" to email,
                    "titulo" to nombre,
                    "caducidad" to caducidad,
                    "description" to description,
                    "ubicacion" to ubicacion,
                    "horas" to horas
                )
                db.collection("Favores")
                    .document()
                    .set(demanda)
                    .addOnSuccessListener {
                        aviso("Exito","Se ha publicado")
                    }
                    .addOnFailureListener{
                        aviso("Error ,", "no se ha podido publicar")
                    }

            }else{
                aviso("error", "por favor completa los campos")
            }


        }
    }

    //alertas informativas
    private fun aviso(title: String, message: String) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    // comprueba si los campos no estan vacios
    private fun comprobarCampos(): Boolean {
        return  binding.caducidadTxt.text.isNotEmpty() &&
                binding.nameTxt.text.isNotEmpty() &&
                binding.descriptionTxt.text.isNotEmpty() &&
                binding.txtCantidadHoras.text.isNotEmpty() &&
                binding.ubicacionTxt.text.isNotEmpty()
    }
}