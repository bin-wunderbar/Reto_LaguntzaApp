package com.example.reto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.reto.databinding.FragmentDetailsChatBinding
import com.example.reto.modelo.UsuariosChat


class DetailsChatFragment : Fragment(R.layout.fragment_details_chat) {
    private lateinit var binding: FragmentDetailsChatBinding
    private val args by navArgs<DetailsChatFragmentArgs>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsChatBinding.bind(view)
        binding.usuariotxt.text = args.chatObject.usuario
        Glide.with(binding.fotoimg.context).load(args.chatObject.photo).into(binding.fotoimg)
        binding.enviar.setOnClickListener{

            Toast.makeText(context, "en fase desarrollo", Toast.LENGTH_SHORT).show()
        }

    }


}