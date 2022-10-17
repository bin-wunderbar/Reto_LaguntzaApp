package com.example.reto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reto.databinding.ActivityAllUserBinding
import com.example.reto.databinding.ActivityReportUserBinding

class ListReportedUser_Activity : AppCompatActivity() {
    lateinit private var binding: ActivityReportUserBinding
    lateinit var UsersList :List<Users>
    lateinit private var rvAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReportUserBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_report_user)
        setContentView(binding.root)

        //cargar datos
        cargarDatos()
        rvAdapter = RvAdapter(UsersList)
        binding.rvListUserReportes.adapter = rvAdapter

    }
    fun cargarDatos(){
        UsersList = listOf(
            Users("Aitor", "Pizarro", "https://robohash.org/HVF.png?set=set4", 3),
            Users("Jaime", "aaaa", "https://robohash.org/S4J.png?set=set4", 5),
            Users("Maite", "Apellido", "https://robohash.org/MBM.png?set=set4", 2),
            Users("BBBBB", "bbbbbbbb", "https://robohash.org/S4F.png?set=set4", 4)
        )
    }



}