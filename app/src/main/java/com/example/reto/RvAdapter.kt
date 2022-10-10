package com.example.reto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reto.databinding.SingleItemsBinding

class RvAdapter (var UsersList : List<Users>) :RecyclerView.Adapter<RvAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater
            .from(parent.context)
            .inflate(R.layout.single_items, parent, false
            )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(UsersList[position])
    }

    override fun getItemCount(): Int { return UsersList.size }

    class ViewHolder (view: View) :RecyclerView.ViewHolder(view) {
        val binding = SingleItemsBinding.bind(view)
        fun bind(us:Users){
            binding.tvNombre.text = us.nombre
            binding.tvApellido.text = us.apellido
        }


    }

}