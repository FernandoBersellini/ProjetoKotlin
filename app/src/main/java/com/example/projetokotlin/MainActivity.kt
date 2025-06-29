package com.example.projetokotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetokotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var modoEdicao : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.textEdit.text = "OFF"
        executarListas()

        binding.btnEdit.setOnClickListener {
            if (!modoEdicao) {
                modoEdicao = true;
                binding.textEdit.text = "ON"
                executarFixar()
            } else {
                modoEdicao = false;
                binding.textEdit.text = "OFF"
                executarListas()
            }
        }

        binding.btnFixadas.setOnClickListener {
            val trocarTela = Intent(this, Fixadas::class.java)
            startActivity(trocarTela)
        }
    }

    private fun executarFixar() {
        binding.btnLista1.setOnClickListener(null)
        binding.btnLista2.setOnClickListener(null)
        binding.btnLista3.setOnClickListener(null)
        binding.btnLista4.setOnClickListener(null)
        binding.btnLista5.setOnClickListener(null)
        binding.btnLista6.setOnClickListener(null)

        ativarBtnFixar()

        binding.btnFixar1.setOnClickListener {
            val trocarTela = Intent(this, Tarefas::class.java)
            startActivity(trocarTela)
        }

        binding.btnFixar2.setOnClickListener {
            val trocarTela = Intent(this, Tarefas::class.java)
            startActivity(trocarTela)
        }

        binding.btnFixar3.setOnClickListener {
            val trocarTela = Intent(this, Tarefas::class.java)
            startActivity(trocarTela)
        }

        binding.btnFixar4.setOnClickListener {
            val trocarTela = Intent(this, Tarefas::class.java)
            startActivity(trocarTela)
        }

        binding.btnFixar5.setOnClickListener {
            val trocarTela = Intent(this, Tarefas::class.java)
            startActivity(trocarTela)
        }

        binding.btnFixar6.setOnClickListener {
            val trocarTela = Intent(this, Tarefas::class.java)
            startActivity(trocarTela)
        }
    }

    private fun executarListas() {
        desativarBtnFixar()

        binding.btnLista1.setOnClickListener {
            val trocarTela = Intent(this, Tarefas::class.java)
            startActivity(trocarTela)
        }

        binding.btnLista2.setOnClickListener {
            val trocarTela = Intent(this, Tarefas::class.java)
            startActivity(trocarTela)
        }

        binding.btnLista3.setOnClickListener {
            val trocarTela = Intent(this, Tarefas::class.java)
            startActivity(trocarTela)
        }
        binding.btnLista4.setOnClickListener {
            val trocarTela = Intent(this, Tarefas::class.java)
            startActivity(trocarTela)
        }

        binding.btnLista5.setOnClickListener {
            val trocarTela = Intent(this, Tarefas::class.java)
            startActivity(trocarTela)
        }

        binding.btnLista6.setOnClickListener {
            val trocarTela = Intent(this, Tarefas::class.java)
            startActivity(trocarTela)
        }
    }

    private fun ativarBtnFixar(){
        binding.btnFixar1.visibility = View.VISIBLE
        binding.btnFixar2.visibility = View.VISIBLE
        binding.btnFixar3.visibility = View.VISIBLE
        binding.btnFixar4.visibility = View.VISIBLE
        binding.btnFixar5.visibility = View.VISIBLE
        binding.btnFixar6.visibility = View.VISIBLE

        binding.pinFixar1.visibility = View.VISIBLE
        binding.pinFixar2.visibility = View.VISIBLE
        binding.pinFixar3.visibility = View.VISIBLE
        binding.pinFixar4.visibility = View.VISIBLE
        binding.pinFixar5.visibility = View.VISIBLE
        binding.pinFixar6.visibility = View.VISIBLE
    }

    private fun desativarBtnFixar() {
        binding.btnFixar1.visibility = View.GONE
        binding.btnFixar2.visibility = View.GONE
        binding.btnFixar3.visibility = View.GONE
        binding.btnFixar4.visibility = View.GONE
        binding.btnFixar5.visibility = View.GONE
        binding.btnFixar6.visibility = View.GONE

        binding.pinFixar1.visibility = View.GONE
        binding.pinFixar2.visibility = View.GONE
        binding.pinFixar3.visibility = View.GONE
        binding.pinFixar4.visibility = View.GONE
        binding.pinFixar5.visibility = View.GONE
        binding.pinFixar6.visibility = View.GONE
    }
}