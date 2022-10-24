package com.example.reto.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.reto.databinding.FragmentHomeBinding
import com.google.firebase.firestore.FirebaseFirestore


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        cargarperfil()
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun cargarperfil(){
        val appContext = requireContext().applicationContext
        val preferences= appContext.getSharedPreferences("Currentuser",
            Context.MODE_PRIVATE)
        var currentuser = preferences.getString("CurrentUser","Usuario")
        val db = FirebaseFirestore.getInstance()
        db.collection("Usuarios")
            .whereEqualTo("email","$currentuser")
            .get()
            .addOnSuccessListener { resultado ->
                val usuario = resultado.documents[Context.MODE_PRIVATE]
                val nombre = usuario.get("nombre")
                val apellidos = usuario.get("apellidos")
                val saldo = usuario.get("saldo")
                val descripcion = usuario.get("descripcion")
                val localidad = usuario.get("localidad")
                val id = usuario.get("id")
                preferences.edit().putString("Userid",id.toString()).apply()
                binding.txtCiudad.setText("${localidad}")
                binding.txtSaldo.setText("${saldo}" + " H")
                binding.txtUsuario.setText("${nombre}")
                binding.txtDescripcion.setText("${descripcion}")

            }
    }
}