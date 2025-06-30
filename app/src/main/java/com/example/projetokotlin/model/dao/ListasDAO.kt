package com.example.projetokotlin.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.projetokotlin.model.entity.Afazeres
import com.example.projetokotlin.model.entity.Lista
import kotlinx.coroutines.flow.Flow

@Dao
interface ListasDAO {

    @Query("Select * from lista")
    fun getAllListas() : Flow<List<Lista>>

    @Insert
    suspend fun insertLista(lista: Lista)

    @Update
    suspend fun updateLista(lista: Lista)

    @Delete
    suspend fun deleteLista(lista: Lista)

    @Query("Select * from afazeres where listaId = :listaId")
    fun getAllAfazeres(listaId: Int) : Flow<List<Afazeres>>

    @Insert
    suspend fun insertAfazeres(afazeres: Afazeres)

    @Update
    suspend fun updateAfazeres(afazeres: Afazeres)

    @Delete
    suspend fun deleteAfazeres(afazeres: Afazeres)

}