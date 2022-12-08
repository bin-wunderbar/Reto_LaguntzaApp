package com.example.reto.modelo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Message(
    var message: String="",
    var from: String="",
    var dob : Date= Date()
): Parcelable
