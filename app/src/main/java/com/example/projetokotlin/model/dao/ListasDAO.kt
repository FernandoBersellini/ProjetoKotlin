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
    suspend fun insertLista(lista: Lista)

    @Update
    suspend fun updateLista(lista: Lista)

    @Delete
    suspend fun deleteLista(lista: Lista)
}