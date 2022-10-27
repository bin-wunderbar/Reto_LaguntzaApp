package com.example.reto.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.reto.databinding.ItemMisDemandasBinding
import com.example.reto.modelo.Ofertas
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat

class DemandasViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemMisDemandasBinding.bind(view)
        var id: String = "nada"
        fun bind(oferta: Ofertas) {

            val simpleDate  = SimpleDateFormat("dd/MM/yyyy HH:mm")
            val currentDate = simpleDate.format(oferta.publicada)


            binding.nameTxt.text        = oferta.name.toString()
            binding.descriptionTxt.text = oferta.descripcion.toString()
            binding.ubicacionTxt.text   = oferta.ubicacion.toString()
            binding.txtFecha.text       = currentDate
            binding.usuarioPublica.text = oferta.usuario.toString()
            if(oferta.asignada == true){
                binding.estado.text = oferta.from.toString()
                binding.btnEliminar.isActivated=false
            }else{binding.estado.text = "Sin asignar"}



            /*//borrar un usuario
            btnDelete = view.findViewById(R.id.textButton)
            btnDelete.setOnClickListener(){

                val binding = FragmentDetailUserReportBinding.bind(view)
                if (binding.idUser.text.isNotBlank()){
                    db.collection("Usuarios").document(binding.idUser.text.toString())
                        .delete()
                    Toast.makeText(context, "entra", Toast.LENGTH_SHORT).show()
                }
                else{
                    binding.textDelete.setText("error")
                }

            }*/
            binding.btnEliminar.setOnClickListener(){
                var cod :String
                if (oferta.asignada.toString()=="false"){
                    val db = FirebaseFirestore.getInstance()
                    db.collection("Ofertas").document(oferta.id.toString()).delete()
                        .addOnSuccessListener {
                            println(oferta.name)
                            println(oferta.id)
                        }
                        .addOnFailureListener(){
                            println("fallo")
                        }
                }
            }
        }
    }
