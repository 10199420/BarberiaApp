package com.example.barbershop

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import com.example.barbershop.databinding.ActivityMainBinding
import com.example.barbershop.view.Home
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnLogin.setOnClickListener {

            val name = binding.ediName.text.toString()
            val pass = binding.ediPass.text.toString()

            when {
                name.isEmpty() -> {
                    mensagge(it, "Coloque su nombre")
                }

                pass.isEmpty() -> {
                    mensagge(it, "Coloque su Password")
                }

                pass.length <= 5 -> {
                    mensagge(it, "Su contraseña debe tener al menos 6 caracteres")
                }

                else -> {
                   navegarforHome(name)
                }

            }
        }
    }


    private fun mensagge(view: View, mensagge: String) {
        val snackbar = Snackbar.make(view, mensagge, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()
    }
    private fun navegarforHome(name: String){
        val intent = Intent(this, Home::class.java)
        intent.putExtra("name",name)
        startActivity(intent)
    }
}