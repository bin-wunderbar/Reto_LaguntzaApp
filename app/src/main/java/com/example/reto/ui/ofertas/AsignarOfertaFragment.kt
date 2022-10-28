package com.example.reto.ui.ofertas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.reto.Clases.RetoApplication.Companion.prefs
import com.example.reto.databinding.FragmentAsignarOfertaBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat


class AsignarOfertaFragment : Fragment() {

    private var _binding : FragmentAsignarOfertaBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<AsignarOfertaFragmentArgs>()
    private lateinit var email : String


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, avedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        email = prefs.getEmail()
        _binding = FragmentAsignarOfertaBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        asignarCampos()
        asignarCandidato()
        reportUser()
    }

    // asignar texto a los campos
    private  fun asignarCampos(){
        // convertir fecha ----------------------------------------------
        val simpleDate  = SimpleDateFormat("dd/MM/yyyy HH:mm")
        val currentDate = simpleDate.format(args.oferta.publicada!!)
        //----------------------------------------------------------------
        binding.estado.text = args.oferta.asignada.toString()
        binding.nameTxt.text = args.oferta.name.toString()
        binding.txtFecha.text = currentDate
        binding.usuarioPublica.text = args.oferta.from.toString()
        binding.ubicacionTxt.text = args.oferta.ubicacion.toString()
        binding.descriptionTxt.text = args.oferta.descripcion.toString()
    }
    // asignar oferta
    private fun asignarCandidato(){
        binding.btnAsignar.setOnClickListener{
            val datos = hashMapOf(
                "from" to email,
                "asignada" to true,
                "id" to args.oferta.id,
                "publicada" to args.oferta.publicada,
                "usuario" to args.oferta.usuario.toString(),
                "name" to args.oferta.name.toString(),
                "descripcion" to args.oferta.descripcion.toString(),
                "ubicacion" to args.oferta.ubicacion.toString(),
                "horas" to args.oferta.horas.toString()
            )
            if (args.oferta.asignada.toString()=="false"){
                val db = FirebaseFirestore.getInstance()
                db.collection("ofertas")
                    .document(args.oferta.id.toString())
                    .set(datos)
                    .addOnSuccessListener {
                        Toast.makeText(binding.nameTxt.context, "datos actualizados", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener(){
                        Toast.makeText(binding.nameTxt.context, "Error", Toast.LENGTH_SHORT).show()
                    }

            }
        }
    }

    // Reportar usuario
    private fun reportUser(){
        binding.btnReportar.setOnClickListener {
            if (args.oferta.asignada.toString()=="false"){
                Toast.makeText(binding.nameTxt.context, "Usuario reportado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}