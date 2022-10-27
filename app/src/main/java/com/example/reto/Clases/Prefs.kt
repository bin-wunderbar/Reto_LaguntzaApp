package com.example.reto.Clases


import android.content.Context

class Prefs(val context: Context) {
    val SHARED_DATA = "MyDatabase"
    val SHARED_EMAIL_ADDRESS = "mail"
    val SHARED_ID = "id"


    val storage = context.getSharedPreferences(SHARED_DATA,0)

    // Guarda email
    fun saveEmail(email: String) {
        storage.edit().putString(SHARED_EMAIL_ADDRESS, email).apply()
    }

    // Guarda id usuario
    fun saveId(id: Int) {
        storage.edit().putString(SHARED_ID, id.toString()).apply()
    }

    // recuperar email
    fun getEmail(): String {
        return storage.getString(SHARED_EMAIL_ADDRESS,"")!!
    }
    // recuperar id
    fun getId(): String {
        return storage.getString(SHARED_ID,"")!!
    }

    // Eleminar los datos guardados
    fun limpiar(){
        storage.edit().clear().apply()
    }
}