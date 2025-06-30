package com.example.projetokotlin.listagem

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetokotlin.model.ListaDB
import com.example.projetokotlin.model.entity.Lista
import com.example.projetokotlin.repositories.ListaRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ListaViewModel(application: Application): AndroidViewModel(application) {
    private val repositorio: ListaRepository
    val todasListas: StateFlow<List<Lista>>

    init {
        val dao = ListaDB.getDatabase(application).listaDao()
        repositorio = ListaRepository(dao)

        todasListas = repositorio.todasListas.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )
    }

    fun adicionarLista(lista: Lista) = viewModelScope.launch {
        repositorio.inserirLista(lista)
    }

    fun deletarLista(lista: Lista) = viewModelScope.launch {
        repositorio.deleteLista(lista)
    }


    fun atualizarLista(lista: Lista) = viewModelScope.launch {
        repositorio.updateLista(lista)
    }
}