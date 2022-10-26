package com.example.reto.ui.home






import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.reto.Clases.RetoApplication.Companion.prefs
import com.example.reto.databinding.FragmentHomeBinding
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat



class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!
    private lateinit var email: String
    private lateinit var id : String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       email = prefs.getEmail()
       cargarperfil()
        binding.btnEdit.setOnClickListener {
            comprobarEmail()
            val action = HomeFragmentDirections.actionNavHomeToEditPerfilFragment(id)
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

        val db = FirebaseFirestore.getInstance()
        db.collection("Usuarios")
            .whereEqualTo("email", email)
            .get()
            .addOnSuccessListener {
                if (!it.isEmpty){
                    val usuario = it.documents[0]
                    val nombre = usuario.get("nombre")
                    val saldo = usuario.get("saldo")
                    val descripcion = usuario.get("description")
                    val localidad = usuario.get("localidad")
                    id    = usuario.get("id").toString()

                    // setea timestamp a la fecha con formato -----------------------
                    val fecha= usuario.get("fecha") as Timestamp
                    val fechaActual= fecha.toDate()
                    val simpleDate = SimpleDateFormat("MMM, yyyy")
                    val currentDate = simpleDate.format(fechaActual)
                    //----------------------------------------------------------------
                    binding.txtCiudad.setText("${localidad}")
                    binding.txtSaldo.setText("${saldo} H")
                    binding.txtUsuario.setText("${nombre}")
                    binding.txtDescripcion.setText("${descripcion}")
                    binding.txtFichaRegistro.text = ("Se unió en ${currentDate}")
                }

            }
    }

}