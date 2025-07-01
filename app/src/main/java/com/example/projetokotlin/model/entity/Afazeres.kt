package com.example.projetokotlin.model.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "afazeres",
    foreignKeys = [ForeignKey(entity = Lista::class,
        parentColumns = ["id"],
        childColumns = ["listaId"],
        onDelete = ForeignKey.CASCADE)],
    indices = [Index("listaId")])
data class Afazeres (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var titulo: String,
    val listaId: Int,
    var marcado: Boolean = false
)