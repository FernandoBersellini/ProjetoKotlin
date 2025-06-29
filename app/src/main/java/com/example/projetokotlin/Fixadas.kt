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
    private var modoEdicao: Boolean = false

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

        binding.btnMain.setOnClickListener {
            val trocarTela = Intent(this, MainActivity::class.java)
            startActivity(trocarTela)
        }
    }
}