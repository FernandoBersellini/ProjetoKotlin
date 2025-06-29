package com.example.projetokotlin.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "afazeres")
data class Afazeres (
    @PrimaryKey(autoGenerate = true) var id: Int,
    var titulo: String
)