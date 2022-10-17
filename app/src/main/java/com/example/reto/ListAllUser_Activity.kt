package com.example.reto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reto.databinding.ActivityAllUserBinding


class ListAllUser_Activity : AppCompatActivity() {
    lateinit private var binding: ActivityAllUserBinding
    lateinit var UsersList :List<Users>
    lateinit private var rvAdapter: RvAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //load data to lenguaje list
        cargarDatos()

        rvAdapter = RvAdapter(UsersList)
        binding.rvListUser.adapter = rvAdapter
    }
    fun cargarDatos(){
        UsersList = listOf(
            Users("Aitor", "Pizarro", "https://robohash.org/HVF.png?set=set4"),
            Users("Jaime", "aaaa", "https://robohash.org/S4J.png?set=set4"),
            Users("Maite", "Apellido", "https://robohash.org/MBM.png?set=set4"),
            Users("BBBBB", "bbbbbbbb", "https://robohash.org/S4F.png?set=set4"),
            Users("CCCCC", "cccccccc", "https://robohash.org/HVF.png?set=set4"),
            Users("DDDDDD", "ddddddd", "https://robohash.org/HVF.png?set=set4"),
            Users("EEEEEE", "eeeeeee", "https://robohash.org/S4F.png?set=set4"),
            Users("FFFFF", "fffffff", "https://robohash.org/HVF.png?set=set4"),
        )
    }

}