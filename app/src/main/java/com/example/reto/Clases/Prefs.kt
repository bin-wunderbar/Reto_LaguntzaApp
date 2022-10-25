package com.example.reto.Clases


import android.content.Context

class Prefs(val context: Context) {
    val SHARED_DATA = "MyDatabase"
    val SHARED_EMAIL_ADDRESS = "mail"

    val storage = context.getSharedPreferences(SHARED_DATA,0)

    // Guarda email
    fun saveEmail(email: String) {
        storage.edit().putString(SHARED_EMAIL_ADDRESS, email).apply()
    }

    // recuperar email
    fun getEmail(): String {
        return storage.getString(SHARED_EMAIL_ADDRESS,"")!!
    }

    // Eleminar los datos guardados
    fun limpiar(){
        storage.edit().clear().apply()
    }
}