package com.example.reto.ui.home



import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.reto.Clases.RetoApplication.Companion.prefs
import com.example.reto.databinding.FragmentHomeBinding
import com.google.firebase.firestore.FirebaseFirestore


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       cargarperfil()
        binding.btnEdit.setOnClickListener {
            comprobarEmail()
            val action = HomeFragmentDirections.actionNavHomeToEditPerfilFragment("pasarleUnEmail.com")
            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun comprobarEmail(){
        val email = prefs.getEmail()
       println(email)
    }

    fun cargarperfil() {
        val email = prefs.getEmail()
        val db = FirebaseFirestore.getInstance()
        db.collection("Usuarios")
            .whereEqualTo("email", email)
            .get()
            .addOnSuccessListener {
                if (!it.isEmpty){
                    val usuario = it.documents[0]
                    val nombre = usuario.get("nombre")
                    val saldo = usuario.get("saldo")
                    val descripcion = usuario.get("descripcion")
                    val localidad = usuario.get("localidad")
                    binding.txtCiudad.setText("${localidad}")
                    binding.txtSaldo.setText("${saldo} H")
                    binding.txtUsuario.setText("${nombre}")
                    binding.txtDescripcion.setText("${descripcion}")
                }

            }
    }

}