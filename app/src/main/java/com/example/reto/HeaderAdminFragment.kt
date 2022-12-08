package com.example.reto

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.reto.databinding.FragmentBodyAllUserBinding

class HeaderAdminFragment : Fragment(R.layout.fragment_header_admin) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var  btnMostrarAllUser: Button
    lateinit var  btnMostrarReportUser: Button
    lateinit var  bb: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_header_admin, container, false)
        //mostrar todos los usuarios
        btnMostrarAllUser = view.findViewById(R.id.btnUser)
        btnMostrarAllUser.setOnClickListener(){
            mostrarAllUser()
        }


        //mostrar usuarios con reportes
        btnMostrarReportUser = view.findViewById(R.id.btnReportUser)
        btnMostrarReportUser.setOnClickListener(){
            mostrarReportUser()
        }
        return view

    }


    fun mostrarAllUser(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.setReorderingAllowed(true)
        fragmentTransaction.replace(R.id.remplazable, BodyAllUserFragment())
        fragmentTransaction.commit()
    }
    fun mostrarReportUser(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.setReorderingAllowed(true)
        fragmentTransaction.replace(R.id.remplazable, BodyReportUserFragment())
        fragmentTransaction.commit()
    }

}