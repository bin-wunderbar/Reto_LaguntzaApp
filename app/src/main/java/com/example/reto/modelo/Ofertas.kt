package com.example.reto.modelo

import android.os.Parcelable
import java.util.*


/*
* clase Ofertas de tipo datos, contine las propiedades: */
@kotlinx.parcelize.Parcelize
data class Ofertas(
    var asignada: Boolean= false,
    var from: String? = null,
    var publicada: Date? = null,
    var email: String ? = null,
    var name: String? = null,
    var caducidad: String? = null,
    var descripcion: String? = null,
    var ubicacion: String? = null,
    var horas: String? = null
): Parcelable


