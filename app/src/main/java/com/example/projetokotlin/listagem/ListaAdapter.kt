package com.example.projetokotlin.listagem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetokotlin.databinding.ItemListaBinding
import com.example.projetokotlin.model.entity.Lista

class ListaAdapter(
    private val onDeleteClick: (Lista) -> Unit,
    private val onFixarClick: (Lista) -> Unit
): RecyclerView.Adapter<ListaAdapter.ListaViewHolder>() {

    private var list: List<Lista> = listOf()
    private var modoEdicao: Boolean = false

    inner class ListaViewHolder(val binding: ItemListaBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(lista: Lista) {
            binding.btnLista.text = lista.titulo

            binding.btnDelete.visibility = if (modoEdicao) View.VISIBLE else View.GONE
            binding.btnFixar.visibility = if (modoEdicao) View.VISIBLE else View.GONE

            binding.btnDelete.setOnClickListener {
                onDeleteClick(lista)
            }

            binding.btnFixar.setOnClickListener {
                onFixarClick(lista)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        val binding = ItemListaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun updateList(list: List<Lista>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.count()

    fun setModoEdicao(modoEdicao: Boolean) {
        this.modoEdicao = modoEdicao
        notifyDataSetChanged()
    }
}