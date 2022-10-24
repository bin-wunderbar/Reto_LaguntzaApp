package com.example.reto.Clases

import android.content.SharedPreferences



fun getUser(sharedPreferences: SharedPreferences){
  val user = sharedPreferences.getString("CurrentUser", "0")
}

