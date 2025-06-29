package com.example.projetokotlin.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.projetokotlin.model.entity.Lista
import kotlinx.coroutines.flow.Flow

@Dao
interface ListasDAO {

    @Query("Select * from lista")
    fun exibirListas() : Flow<List<Lista>>

    @Insert
    fun insertLista(lista: Lista)

    @Update
    fun updateLista(lista: Lista)

    @Delete
    fun deleteLista(lista: Lista)
}