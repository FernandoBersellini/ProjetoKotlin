package com.example.projetokotlin.view

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projetokotlin.listagem.ListaAdapter
import com.example.projetokotlin.databinding.ActivityMainBinding
import com.example.projetokotlin.listagem.ListaViewModel
import com.example.projetokotlin.model.entity.Lista
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaAdapter: ListaAdapter
    private var modoEdicao: Boolean = false

    private val viewModel: ListaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        executarRecyclerView()
        carregarListas()
        configuraBotoes()
    }

    private fun executarRecyclerView() {
        listaAdapter = ListaAdapter(
            onListaClick = { lista ->
                var intent = Intent(this, Tarefas::class.java)
                intent.putExtra("listaId", lista.id)
                intent.putExtra("titulo", lista.titulo)
                startActivity(intent)
            },
            onDeleteClick = { lista -> viewModel.deletarLista(lista)},
            onFixarClick = { lista ->
                val atualizada = lista.copy(fixada = !lista.fixada)
                viewModel.atualizarLista(atualizada)
            }
        )
        binding.listasGrid.adapter = listaAdapter
        binding.listasGrid.layoutManager = GridLayoutManager(this, 2)
    }

    private fun carregarListas() {
        lifecycleScope.launch {
            viewModel.todasListas.collect { listas ->
                listaAdapter.updateList(listas)
            }
        }
    }

    private fun configuraBotoes() {
        binding.btnCreate.setOnClickListener {
            val input = EditText(this).apply {
                hint = "Digite o nome da lista"
            }

            AlertDialog.Builder(this)
                .setTitle("Criar nova lista")
                .setView(input)
                .setPositiveButton("Criar") { _, _ ->
                    val nomeDaLista = input.text.toString().trim()
                    if(nomeDaLista.isNotEmpty()) {
                        lifecycleScope.launch {
                            val novaLista = Lista(0, nomeDaLista, false)
                            viewModel.adicionarLista(novaLista)
                        }
                    }
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }

        binding.btnFixadas.setOnClickListener {
            startActivity(Intent(this, Fixadas::class.java))
        }

        binding.btnEdit.setOnClickListener {
            modoEdicao = !modoEdicao
            binding.textEdit.text = if (modoEdicao) "ON" else "OFF"
            listaAdapter.setModoEdicao(modoEdicao)
        }
    }
}