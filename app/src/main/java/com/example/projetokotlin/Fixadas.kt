package com.example.projetokotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetokotlin.databinding.ActivityFixadasBinding

class Fixadas : AppCompatActivity() {

    private lateinit var binding : ActivityFixadasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFixadasBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnListaFixada1.setOnClickListener {
            val trocarTela = Intent(this, Tarefas::class.java)
            startActivity(trocarTela)
        }

        binding.btnListaFixada2.setOnClickListener {
            val trocarTela = Intent(this, Tarefas::class.java)
            startActivity(trocarTela)
        }

        binding.btnListaFixada3.setOnClickListener {
            val trocarTela = Intent(this, Tarefas::class.java)
            startActivity(trocarTela)
        }

        binding.btnMain.setOnClickListener {
            val trocarTela = Intent(this, MainActivity::class.java)
            startActivity(trocarTela)
        }
    }
}