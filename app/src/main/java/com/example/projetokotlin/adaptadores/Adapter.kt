package com.example.projetokotlin.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.projetokotlin.databinding.ItemListaBinding
import com.example.projetokotlin.model.entity.Lista

class Adapter: RecyclerView.Adapter<Adapter.ListaViewHolder>() {

    private var list: List<Lista> = listOf()

    inner class ListaViewHolder(val binding: ItemListaBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(lista: Lista) {
            binding.btnLista.text = lista.titulo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        val binding = ItemListaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    fun updateList(lista: List<Lista>) {
        this.list = list
        notifyDataSetChanged()
    }
}