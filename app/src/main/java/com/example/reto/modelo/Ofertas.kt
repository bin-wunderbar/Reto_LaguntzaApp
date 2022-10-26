package com.example.reto.modelo

import android.os.Parcelable
import java.util.*


/*
* clase Ofertas de tipo datos, contine las propiedades:
* - name: nombre de oferta en chat, tipo String
* - description: pequeño resumen de la oferta, tipo String
* - ubicacion: donde se ha publicado la oferta, tipo String de momento
* - caducidad: de tipo int indica cuando caduda la oferta
* - photo: de tipo String de momento no se le da uso, para futuras actualizaciones
* */
@kotlinx.parcelize.Parcelize
data class Ofertas(
    val asignada: Boolean= false,
    val publicada: Date? = null,
    val email: String ? = null,
    val nombre: String? = null,
    val caducidad: String? = null,
    val descripcion: String? = null,
    val ubicacion: String? = null,
    val horas: String? = null
): Parcelable


