package com.example.reto.adapter

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.reto.Clases.RetoApplication.Companion.prefs
import com.example.reto.databinding.ItemOfertasGeneralesBinding
import com.example.reto.modelo.Ofertas
import com.example.reto.ui.ofertas.FavoresFragmentDirections
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat

class OfertasViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemOfertasGeneralesBinding.bind(view)
    val email = prefs.getEmail()
    fun bind(oferta: Ofertas) {

        val simpleDate = SimpleDateFormat("dd/MM/yyyy HH:mm")
        val currentDate = simpleDate.format(oferta.publicada)

        prefs.saveId(oferta.id!!)
        binding.nameTxt.text        = oferta.name.toString()
        binding.descriptionTxt.text = oferta.descripcion.toString()
        binding.ubicacionTxt.text   = oferta.ubicacion.toString()
        binding.usuarioPublica.text = oferta.usuario.toString()
        binding.txtFecha.text =  currentDate
        if(oferta.asignada == true){
            binding.estado.text = oferta.from.toString()
        }else{binding.estado.text = "Sin asignar"}


        // al dar click sobre la carta muestra mensaje con nombre de la carta

      /*  binding.button.setOnClickListener{
                var cod :String
                if (oferta.asignada.toString()=="false"){
                    val db = FirebaseFirestore.getInstance()
                    db.collection("Ofertas")
                        .document(oferta.id.toString()).update("from",email)
                        .addOnSuccessListener {
                            Toast.makeText(binding.nameTxt.context, "email actualizado", Toast.LENGTH_SHORT).show()
                            println("hecho"+oferta.id+ ": " + email)
                        }
                        .addOnFailureListener(){
                            println("fallo "+oferta.id+ ": " + email)
                        }
                }
        }*/
    }
}