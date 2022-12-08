package com.example.reto.modelo

import android.os.Parcelable
import java.util.*


/*
* clase Ofertas de tipo datos, contine las propiedades: */
@kotlinx.parcelize.Parcelize
data class Ofertas(
    var id: Int? = null,
    var asignada: Boolean?= false,
    var from: String? = null,
    var publicada: Date? = null,
    var usuario: String ? = null,
    var name: String? = null,
    var descripcion: String? = null,
    var ubicacion: String? = null,
    var horas: String? = null
): Parcelable


