package com.example.reto.modelo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chat(
    var id: String ="",
    var name: String = "",
    var users: List<String> = emptyList(),
): Parcelable
