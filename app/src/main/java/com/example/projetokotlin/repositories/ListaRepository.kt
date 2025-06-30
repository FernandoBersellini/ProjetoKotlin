package com.example.projetokotlin.repositories

import com.example.projetokotlin.model.dao.ListasDAO
import com.example.projetokotlin.model.entity.Afazeres
import com.example.projetokotlin.model.entity.Lista
import kotlinx.coroutines.flow.Flow

class ListaRepository(private val dao: ListasDAO) {

    val todasListas: Flow<List<Lista>> = dao.getAllListas()

    fun todosAfazeres(listaId: Int): Flow<List<Afazeres>> {
        return dao.getAllAfazeres(listaId)
    }

    suspend fun inserirLista(lista: Lista) {
        dao.insertLista(lista)
    }

    suspend fun updateLista(lista: Lista) {
        dao.updateLista(lista)
    }

    suspend fun deleteLista(lista: Lista) {
        dao.deleteLista(lista)
    }

    suspend fun inserirAfazer(afazeres: Afazeres) {
        dao.insertAfazeres(afazeres)
    }

    suspend fun updateAfazer(afazeres: Afazeres) {
        dao.updateAfazeres(afazeres)
    }

    suspend fun deleteAfazer(afazeres: Afazeres) {
        dao.deleteAfazeres(afazeres)
    }

}