package com.example.reto

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import com.example.reto.databinding.FragmentMisDemandasBinding


class MisDemandasFragment : Fragment() {
    private var _binding: FragmentMisDemandasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMisDemandasBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        // lanza fragment añadir demanda nueva
        binding.btnAddDemanda.setOnClickListener{
          val action = FavoresFragmentDirections.actionFavoresToAddDemandaFragment2()
            findNavController().navigate(action)

            }
        }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}