package com.example.reto.modelo

import com.example.reto.modelo.Ofertas

class OfertasProvider {
    companion object{
        var listaOfertas = listOf(
            Ofertas("Modanzas",
                "lorem Ipsum caption et justo eiusmod tempor incididunt ut lab",
                "Sestao",
                10,
                "foto.com"
            ),
            Ofertas(
                "Cuidado mayores",
                "lorem Ipsum caption et justo eiusmod tempor incididunt ut lab",
                "Sestao",
                10,
                "foto.com"
            ),
            Ofertas(
                "Lunch comidas",
                "lorem Ipsum caption et justo eiusmod tempor incididunt ut lab",
                "Sestao",
                10,
                "foto.com"
            ),
            Ofertas("Pintar salon",
                "lorem Ipsum caption et justo eiusmod tempor incididunt ut lab",
                "Sestao",
                10,
                "foto.com"
            ),
            Ofertas(
                "Lorem Ipsom",
                "lorem Ipsum caption et justo eiusmod tempor incididunt ut lab",
                "Sestao",
                10,
                "foto.com"
            ),
        )
    }
}