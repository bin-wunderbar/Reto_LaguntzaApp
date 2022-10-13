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
            Users("Aitor", "Pizarro"),
            Users("Jaime", "aaaa"),
            Users("Maite", "Apellido"),
            Users("BBBBB", "bbbbbbbb"),
            Users("CCCCC", "cccccccc"),
            Users("DDDDDD", "ddddddd"),
            Users("EEEEEE", "eeeeeee"),
            Users("FFFFF", "fffffff"),
        )
    }

}