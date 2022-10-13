package com.example.reto.modelo

import com.example.reto.modelo.UsuariosChat

class ChatProvider {
    companion object{
        var listachat = listOf(
        UsuariosChat(
            "Alex",
            "Hello dear",
            "30/09",
            2,
            "https://robohash.org/e836775374af549b5cc617ed7d6954c6?set=set4&bgset=&size=200x200"
        ),
        UsuariosChat(
            "Melon",
            "Hola, estas libre",
            "01/10",
            9,
            "https://robohash.org/20d22d77c5f3cc2383d254ef87388db9?set=set4&bgset=&size=200x200"
        ),
        UsuariosChat(
            "Pato",
            "El plan de la tarde sigue en pie",
            "08/10",
            4,
            "https://robohash.org/fecc105b9e63ddda29bcc1394a8a9093?set=set4&bgset=&size=200x200"
        ),
        UsuariosChat(
            "Ander",
            "Genial",
            "08/10",
            7,
            "https://robohash.org/fe814963ff9f58142a2c2cdbd29b5825?set=set4&bgset=&size=200x200"
        ),
        UsuariosChat(
            "Edson",
            "Llamame cuando puedas",
            "09/10",
            3,
            "https://robohash.org/d5951cc4791e77d64b93ede4e5206f32?set=set4&bgset=&size=200x200"
        ),
        UsuariosChat(
            "Jhon",
            "lorem lapsom",
            "10/10",
            1,
            "https://robohash.org/c03b8f9327f340d07431b1c3f7b9ae18?set=set4&bgset=&size=200x200"
        ),
        )
    }
}