package com.example.projetokotlin.repositories

import com.example.projetokotlin.model.dao.ListasDAO
import com.example.projetokotlin.model.entity.Lista
import kotlinx.coroutines.flow.Flow

class ListaRepository(private val dao: ListasDAO) {

    val todasListas: Flow<List<Lista>> = dao.getAllListas()

    suspend fun inserirLista(lista: Lista) {
        dao.insertLista(lista)
    }

    suspend fun updateLista(lista: Lista) {
        dao.updateLista(lista)
    }

    suspend fun deleteLista(lista: Lista) {
        dao.deleteLista(lista)
    }

}