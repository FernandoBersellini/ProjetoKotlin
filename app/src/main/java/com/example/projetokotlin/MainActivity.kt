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
    private var modoEdicao: Boolean = false

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
    }
}