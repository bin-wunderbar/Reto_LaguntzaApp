package com.example.reto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.navArgs
import com.example.reto.databinding.FragmentEditPerfilBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class EditPerfilFragment : Fragment() {

    private var _binding : FragmentEditPerfilBinding? = null
    private val binding get() = _binding!!
    private lateinit var id : String
    private val args by navArgs<EditPerfilFragmentArgs>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentEditPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        id= args.email
        super.onViewCreated(view, savedInstanceState)

        binding.btnEdit.setOnClickListener{
            guardarDatos()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun guardarDatos(){

        // si el campo txt ciudad no esta vacio
        if(binding.txtCiudad.text.isNotEmpty()){
            val ciudad = binding.txtCiudad.text.toString()
            updateData("localidad", ciudad,id)
        }
        // si el campo de descripcion no esta vacio
        if (binding.txtDescripcion.text.toString().isNotEmpty()){
            val descripcion = binding.txtDescripcion.text.toString()
            updateData("description", descripcion,id)
        }
        // si el campo de nombre no esta vacio
        if (binding.txtUsuario.text.isNotEmpty()) {
            val usuario = binding.txtUsuario.text.toString()
            updateData("nombre", usuario,id)
        }

        // si el campo de apellidos no esta vacio
        if (binding.txtApellidos.text.isNotEmpty()) {
            val apellidos = binding.txtApellidos.text.toString()
            updateData("apellidos", apellidos,id)
        }

        // si los campos de la contraseña no estan vacios y cuenciden
      /*  if (binding.txtPassword.text.isNotEmpty() && binding.txtConfirmarPassword.text.isNotEmpty()) {
            val pass = binding.txtPassword.text.toString()
            val confirmpassword = binding.txtConfirmarPassword.text.toString()
            if (pass == confirmpassword) {
                val user = FirebaseAuth.getInstance().currentUser

                user!!.updatePassword(pass).addOnCompleteListener{ task ->
                    if (task.isSuccessful) {


                    }
                }

            }else{
                aviso("error", "las contraseña no son iguales")
            }
        }*/

    }

    private fun aviso(title: String, message: String) {
        //alertas
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun updateData(campoBd: String, texto: String, id: String) {
        val db = FirebaseFirestore.getInstance()

        db.collection("Usuarios")
            .document(id)
            .update(campoBd, texto)

            .addOnSuccessListener {
                aviso("Exito"," cambiados con exito")

            }
            .addOnFailureListener(){
                aviso("Error","Error al actualizar la $campoBd")

            }
    }


}