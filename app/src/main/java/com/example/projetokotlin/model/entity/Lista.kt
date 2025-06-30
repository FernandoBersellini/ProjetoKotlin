package com.example.projetokotlin.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lista")
data class Lista(
    @PrimaryKey(autoGenerate = true) var id : Int = 0,
    var titulo: String,
    var fixada: Boolean
)