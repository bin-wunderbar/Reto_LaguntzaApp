package com.example.reto.ui.ofertas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.reto.Clases.RetoApplication.Companion.prefs
import com.example.reto.databinding.FragmentAddDemandaBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.util.*


class AddDemandaFragment : Fragment() {
    private var _binding: FragmentAddDemandaBinding? = null
    private val binding get() = _binding!!
    private lateinit var email : String
    private  var saldo: Int = 0
    var idOferta: Int = 0




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddDemandaBinding.inflate(inflater, container, false)
        val root: View = binding.root
        getSaldo()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        email = prefs.getEmail()
        binding.btnPublicar.setOnClickListener{
            if (comprobarCampos()){
                publicarFavor()
            }else{
                aviso("error", "Por favor completa los campos")
            }
        }
    }

    //Alertas informativas
    private fun aviso(title: String, message: String) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    // Comprueba si los campos no estan vacios
    private fun comprobarCampos(): Boolean {
        return  binding.nameTxt.text.isNotEmpty() &&
                binding.descriptionTxt.text.isNotEmpty() &&
                binding.txtCantidadHoras.text.isNotEmpty() &&
                binding.ubicacionTxt.text.isNotEmpty()
    }

    // Asigna saldo del usuario
    private fun getSaldo() {
        val db = FirebaseFirestore.getInstance()
        email = prefs.getEmail()
        db.collection("Usuarios")
            .whereEqualTo("email", email)
            .get()
            .addOnSuccessListener { resultado ->
                val codigo = resultado.documents[0]
                val codigo2 = codigo.get("saldo")
                val result = codigo2.toString()
                saldo = result.toInt()
            }
    }

    // Publicar favor
    private fun publicarFavor(){
        val nombre       = binding.nameTxt.text.toString()
        val description  = binding.descriptionTxt.text.toString()
        val ubicacion    = binding.ubicacionTxt.text.toString()
        val horas        = binding.txtCantidadHoras.text.toString()
        println("resultado antes: " +idOferta)
        generarId()

        val db = FirebaseFirestore.getInstance()
        val demanda = hashMapOf(
            "id" to idOferta,
            "asignada" to false,
            "from" to "",
            "publicada" to Date(),
            "usuario" to email,
            "name" to nombre,
            "descripcion" to description,
            "ubicacion" to ubicacion,
            "horas" to horas
        )
        println("resultado: " +idOferta)
        db.collection("ofertas")
            .document(idOferta.toString())
            .set(demanda)
            .addOnSuccessListener {
                aviso("Exito","Se ha publicado")
                println("resultado: a la hora  " +idOferta)
            }
            .addOnFailureListener{
                aviso("Error ,", "no se ha podido publicar")
            }
    }

    // genera id de ofertas
    fun generarId():Int{
        var cod :String
        val db = FirebaseFirestore.getInstance()
        db.collection("ofertas")
            //ordenar por desceniente limite de 1 haciendo q solo coja el mas grande
            .orderBy("id", Query.Direction.DESCENDING).limit(1)
            .get()
            .addOnSuccessListener { docs->
                var dato = ""
                for  (documento in docs){
                    dato += "${documento.get("id")}\n"
                    cod = dato.get(0).toString()
                    println("preuba numero $cod")
                    idOferta = cod.toInt()
                }
                idOferta += 1
            }
            .addOnFailureListener(){
                println("fallo")
            }
        return idOferta
    }
}