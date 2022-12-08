package com.example.reto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Users(
            val apellidos: String? = null,
            val email: String? = null,
            val id: Int? = null,
            val localidad: String? = null,
            val nombre: String? = null,
            val pass: String?= null,
            val reportes:Int? = null,
            //val saldo: Int? = null
) : Parcelable{


}