package com.example.reto.modelo

/*
* clase Ofertas de tipo datos, contine las propiedades:
* - name: nombre de oferta en chat, tipo String
* - description: pequeño resumen de la oferta, tipo String
* - ubicacion: donde se ha publicado la oferta, tipo String de momento
* - caducidad: de tipo int indica cuando caduda la oferta
* */
data class Ofertas(
    val name: String,
    val description: String,
    val ubicacion: String,
    val caducidad: Int,
    val photo :String
    )
