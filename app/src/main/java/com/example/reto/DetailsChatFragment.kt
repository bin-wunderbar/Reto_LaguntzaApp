package com.example.reto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.example.reto.databinding.FragmentDetailsChatBinding
import com.example.reto.modelo.UsuariosChat


class DetailsChatFragment : Fragment() {
    private var fragmentDetailsChatBinding: FragmentDetailsChatBinding? = null


    companion object{
        const val EXTRA_USER ="Detail"
        fun create(chat: UsuariosChat): DetailsChatFragment {
            val fragment = DetailsChatFragment()
            fragment.arguments = bundleOf(EXTRA_USER to chat)
            return fragment
        }


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val chat = arguments?.getParcelable<UsuariosChat>(EXTRA_USER)
        if(chat != null){
            val binding = FragmentDetailsChatBinding.bind(view)
            fragmentDetailsChatBinding = binding
            Glide.with(binding.fotoimg).load(chat.photo).into(binding.fotoimg)
            binding.usuariotxt.text = chat.usuario

        }
    }


}