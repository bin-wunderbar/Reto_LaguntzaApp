package com.example.reto

/*
* clase UsuarioChat de tipo datos, contine las propiedades:
* - usuario: nombre de usuario en chat tipo String
* - mensaje: ultimo mensaje recibido tipo String
* - fecha: fecha ha recibido ultimo mensaje, usaremos de tipo String de momento
* - numero: de tipo int indica cuantos mensajes estan sin leer
* */
data class UsuariosChat(val usuario :String ="", val mensaje : String ="", val fecha :String ="", val numero : Int = 0){}
