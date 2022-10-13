package com.example.reto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reto.databinding.ActivityAdminBinding

class Admin_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityAdminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //listar todos los usuarios
        binding.btnradioListarUser.setOnClickListener(){
            val intent = Intent (this, ListAllUser_Activity::class.java).apply {

            }
            startActivity(intent)
        }
        //listar solo usuarios con reportes
        binding.btnradioReportUser.setOnClickListener(){
            //val intent = Intent(this, ReportUserActivity::class.java).apply {
            val intent = Intent (this, ListAllUser_Activity::class.java).apply {

            }
            startActivity(intent)
        }




    }
}