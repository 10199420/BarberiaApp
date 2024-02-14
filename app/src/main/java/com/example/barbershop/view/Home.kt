package com.example.barbershop.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.barbershop.R
import com.example.barbershop.adapter.ServiciosAdapter
import com.example.barbershop.databinding.ActivityHomeBinding
import com.example.barbershop.model.Servicios

class Home : AppCompatActivity() {

      private lateinit var binding: ActivityHomeBinding
      private lateinit var serviciosAdapter: ServiciosAdapter
      private val listaServicios:MutableList<Servicios> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

          supportActionBar?.hide()
          val name = intent.extras?.getString("name")

          binding.textNombreUsuario.text ="Bienvenido $name"
        val recyclerViewServicios = binding.recyclerViewServicios
        recyclerViewServicios.layoutManager = GridLayoutManager(this,2)
        serviciosAdapter = ServiciosAdapter(this,listaServicios)
        recyclerViewServicios.setHasFixedSize(true)
        recyclerViewServicios.adapter = serviciosAdapter
        getServicios()

        binding.btnAgendar.setOnClickListener{
            val intent = Intent(this,Agendamiento::class.java)
            intent.putExtra("name",name)
            startActivity(intent)
        }
    }

     private fun getServicios(){

         val servicio1 = Servicios(R.drawable.img1,"Corte de Cabello")
         listaServicios.add(servicio1)

         val servicio2 = Servicios(R.drawable.img2,"Corte de Barba")
         listaServicios.add(servicio2)

         val servicio3 = Servicios(R.drawable.img3,"Lavado de Cabello")
         listaServicios.add(servicio3)

         val servicio4 = Servicios(R.drawable.img4,"Tratamiento de Cabello")
         listaServicios.add(servicio4)

     }
}