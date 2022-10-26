package com.example.reto.Clases

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.reto.*

class PagerAdapter(fragmentActivity: FavoresFragment): FragmentStateAdapter(fragmentActivity){
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0-> {
                MisDemandasFragment()
            }
            1-> {
                MisOfertasFragment()
            }
            2-> {
                OfertasGeneralesFragment()
            }
            else -> {AddDemandaFragment()}
        }
    }
}