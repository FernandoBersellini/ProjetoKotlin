package com.example.projetokotlin.listagem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetokotlin.databinding.ItemListaFixadaBinding
import com.example.projetokotlin.model.entity.Lista

class ListaFixadaAdapter(
    private val onListaClick: (Lista) -> Unit,
    private val onDesfixarClick: (Lista) -> Unit
): RecyclerView.Adapter<ListaFixadaAdapter.ListaFixadaViewHolder>() {

    private var list: List<Lista> = listOf()
    private var modoEdicao: Boolean = false

    inner class ListaFixadaViewHolder(val binding: ItemListaFixadaBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(lista: Lista) {
            binding.listaText.text = lista.titulo

            binding.btnDesfixar.visibility = if (modoEdicao) View.VISIBLE else View.GONE

            binding.btnLista.setOnClickListener {
                onListaClick(lista)
            }

            binding.btnDesfixar.setOnClickListener {
                onDesfixarClick(lista)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaFixadaViewHolder {
        val binding = ItemListaFixadaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListaFixadaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListaFixadaViewHolder, position: Int) {
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