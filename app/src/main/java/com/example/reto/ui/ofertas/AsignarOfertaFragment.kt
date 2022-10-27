package com.example.reto.ui.ofertas

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.reto.Clases.RetoApplication
import com.example.reto.Clases.RetoApplication.Companion.prefs
import com.example.reto.R
import com.example.reto.databinding.FragmentAsignarOfertaBinding
import com.example.reto.databinding.FragmentEliminarOfertaBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*


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
        // Desactiva la rotacion de la pantalla
        getActivity()?.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        super.onViewCreated(view, savedInstanceState)

        asignarCampos()
        asignarCandidato()


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


}