package com.example.projetokotlin.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projetokotlin.databinding.ActivityFixadasBinding
import com.example.projetokotlin.listagem.ListaFixadaAdapter
import com.example.projetokotlin.listagem.ListaViewModel
import kotlinx.coroutines.launch

class Fixadas : AppCompatActivity() {

    private lateinit var binding : ActivityFixadasBinding
    private lateinit var listaFixadaAdapter: ListaFixadaAdapter
    private var modoEdicao: Boolean = false

    private val viewModel: ListaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFixadasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        executarRecyclerView()
        configuraBotoes()
        carregarListas()
    }

    private fun executarRecyclerView() {
        listaFixadaAdapter = ListaFixadaAdapter(
            onListaClick = { lista ->
                var intent = Intent(this, Tarefas::class.java)
                intent.putExtra("listaId", lista.id)
                intent.putExtra("titulo", lista.titulo)
                startActivity(intent)
            },
            onDesfixarClick = { lista ->
                val desfixar = lista.copy(fixada = false)
                viewModel.atualizarLista(desfixar)
            }
        )
        binding.listasGrid.adapter = listaFixadaAdapter
        binding.listasGrid.layoutManager = GridLayoutManager(this, 2)
    }

    private fun carregarListas() {
        lifecycleScope.launch {
            viewModel.todasListas.collect { listas ->
                val fixadas = listas.filter { it.fixada }
                listaFixadaAdapter.updateList(fixadas)
            }
        }
    }
    private fun configuraBotoes() {
        binding.btnMain.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.btnMain.setOnClickListener {
            val trocarTela = Intent(this, MainActivity::class.java)
            startActivity(trocarTela)
        }

        binding.btnEdit.setOnClickListener {
            modoEdicao = !modoEdicao
            binding.textEdit.text = if (modoEdicao) "ON" else "OFF"
            listaFixadaAdapter.setModoEdicao(modoEdicao)
        }
    }
}