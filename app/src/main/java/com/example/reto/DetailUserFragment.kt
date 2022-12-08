package com.example.reto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.reto.databinding.FragmentDetailUserBinding


class DetailUserFragment : Fragment(R.layout.fragment_detail_user) {

    companion object {
        const val EXTRA_USER = "DetailFragment:extraUser"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = arguments?.getParcelable<Users>(EXTRA_USER)
        if (user!= null){
            val binding = FragmentDetailUserBinding.bind(view)

            //( requireActivity() as AppCompatActivity).supportActionBar?.title=user.nombre
            //Glide.with(binding.thumb).load(movie.url).into(binding.thumb)
            binding.txtUsuario.text = user.nombre
            binding.txtApellidos.text = user.apellidos
            binding.numReportes.setText("${user.reportes}")
        }


    }

}