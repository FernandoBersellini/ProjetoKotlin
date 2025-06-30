package com.example.projetokotlin.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.Room
import com.example.projetokotlin.R
import com.example.projetokotlin.adaptadores.Adapter
import com.example.projetokotlin.databinding.ActivityMainBinding
import com.example.projetokotlin.model.Database
import com.example.projetokotlin.model.entity.Lista
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: Adapter
    private val lista: MutableList<Lista> = mutableListOf()
    private var modoEdicao: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = Room.databaseBuilder(applicationContext, Database::class.java, "bancoDeListas").build()

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.textEdit.text = "OFF"

        binding.btnEdit.setOnClickListener {
            if (!modoEdicao) {
                modoEdicao = true;
                binding.textEdit.text = "ON"
            } else {
                modoEdicao = false;
                binding.textEdit.text = "OFF"
            }
        }

        binding.btnFixadas.setOnClickListener {
            val trocarTela = Intent(this, Fixadas::class.java)
            startActivity(trocarTela)
        }

        binding.btnCreate.setOnClickListener {
            lifecycleScope.launch {
                val lista = Lista(0, "Teste", true)
                database.listaDao().insertLista(lista)
            }
        }

        executarRecyclerView()
    }

    private fun executarRecyclerView() {
        adapter = Adapter()
        val layoutManager = GridLayoutManager(this, 2)

        binding.listasGrid.adapter = adapter
        binding.listasGrid.layoutManager = layoutManager

        adapter.updateList(lista)
    }

}