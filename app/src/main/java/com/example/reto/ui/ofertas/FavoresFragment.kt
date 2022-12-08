package com.example.reto.ui.ofertas

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.reto.Clases.PagerAdapter
import com.example.reto.databinding.FragmentFavoresBinding
import com.google.android.material.tabs.TabLayoutMediator


class FavoresFragment : Fragment() {

    private var _binding: FragmentFavoresBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View{
        // Inflate the layout for this fragment
        _binding = FragmentFavoresBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = PagerAdapter(this)
        TabLayoutMediator(binding.tabLayout,binding.viewPager){ tab,index ->
            tab.text = when (index) {
                0 -> {"Mis Demandas"}
                1 -> {"Mis Ofertas"}
                2 -> {"Ofertas Generales"}
                else -> {throw Resources.NotFoundException("Post not found")}
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


