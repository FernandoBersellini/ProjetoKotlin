package com.example.projetokotlin.listagem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetokotlin.databinding.ItemListaBinding
import com.example.projetokotlin.databinding.ItemTarefaBinding
import com.example.projetokotlin.model.entity.Afazeres
import com.example.projetokotlin.model.entity.Lista

class AfazeresAdapter(
    private val onCheckedChange: (Afazeres) -> Unit,
    private val onDeleteClick: (Afazeres) -> Unit
): RecyclerView.Adapter<AfazeresAdapter.AfazeresViewHolder>() {

    private var list: List<Afazeres> = listOf()
    private var modoEdicao: Boolean = false

    inner class AfazeresViewHolder(val binding: ItemTarefaBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(afazeres: Afazeres) {

            binding.afazer.text = afazeres.titulo
            binding.afazer.isChecked = afazeres.marcado

            binding.afazer.setOnCheckedChangeListener { _, isChecked ->
                onCheckedChange(afazeres.copy(marcado = isChecked))
            }

            binding.btnDelete.visibility = if (modoEdicao) View.VISIBLE else View.GONE

            binding.btnDelete.setOnClickListener {
                onDeleteClick(afazeres)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AfazeresViewHolder {
        val binding = ItemTarefaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AfazeresViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AfazeresViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun updateList(list: List<Afazeres>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.count()

    fun setModoEdicao(modoEdicao: Boolean) {
        this.modoEdicao = modoEdicao
        notifyDataSetChanged()
    }
}