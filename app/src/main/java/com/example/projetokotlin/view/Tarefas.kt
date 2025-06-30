package com.example.projetokotlin.view

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetokotlin.databinding.ActivityTarefasBinding
import com.example.projetokotlin.listagem.AfazeresAdapter
import com.example.projetokotlin.listagem.ListaViewModel
import com.example.projetokotlin.model.entity.Afazeres
import kotlinx.coroutines.launch

class Tarefas : AppCompatActivity() {
    private lateinit var binding: ActivityTarefasBinding
    private lateinit var afazeresAdapter: AfazeresAdapter
    private var modoEdicao: Boolean = false
    private var listaId: Int = -1
    private var titulo: String = ""

    private val viewModel: ListaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTarefasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaId = intent.getIntExtra("listaId", -1)
        titulo = intent.getStringExtra("titulo") ?: ""

        binding.listName.text = titulo

        binding.btnMain.setOnClickListener {
            finish()
        }

        executarRecyclerView()
        carregarListas()
        configuraBotoes()
    }

    private fun executarRecyclerView() {
        afazeresAdapter = AfazeresAdapter (
            onDeleteClick = { afazeres ->
                viewModel.deletarAfazer(afazeres)}
        )

        binding.tarefasLinear.adapter = afazeresAdapter
        binding.tarefasLinear.layoutManager = LinearLayoutManager(this)
    }
    private fun carregarListas() {
        lifecycleScope.launch {
            viewModel.todosAfazeres(listaId).collect { afazeres ->
                afazeresAdapter.updateList(afazeres)
            }
        }
    }
    private fun configuraBotoes() {
        binding.btnCreate.setOnClickListener {
            lifecycleScope.launch {
                val novoAfazer = Afazeres(0,"Teste2", listaId)
                viewModel.adicionarAfazer(novoAfazer)
            }
        }

        binding.btnEdit.setOnClickListener {
            modoEdicao = !modoEdicao
            binding.textEdit.text = if (modoEdicao) "ON" else "OFF"
            afazeresAdapter.setModoEdicao(modoEdicao)
        }
    }
}