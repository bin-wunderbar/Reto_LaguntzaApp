package com.example.reto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.reto.databinding.SingleItemsUserBinding

class RvAdapter (var UsersList : List<Users>) :RecyclerView.Adapter<RvAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater
            .from(parent.context)
            .inflate(R.layout.single_items_user, parent, false
            )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(UsersList[position])
    }

    override fun getItemCount(): Int { return UsersList.size }

    class ViewHolder (view: View) :RecyclerView.ViewHolder(view) {
        val binding = SingleItemsUserBinding.bind(view)
        fun bind(us:Users){
            binding.tvNombre.text = us.nombre
            binding.tvApellido.text = us.apellido
            Glide.with(binding.imgFoto.context).load(us.imagen).into(binding.imgFoto)
            binding.numReportes.setText("${us.reportes}")
        }


    }

}