package com.example.barbershop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.databinding.ServiciosItemBinding
import com.example.barbershop.model.Servicios

class ServiciosAdapter (private val context: Context, private val listaServicios: MutableList<Servicios>):
      RecyclerView.Adapter<ServiciosAdapter.ServiciosViewHolder>(){



      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiciosViewHolder {
             val itemLista = ServiciosItemBinding.inflate(LayoutInflater.from(context),parent,false)
            return ServiciosViewHolder(itemLista)
      }

      override fun getItemCount()= listaServicios.size

      override fun onBindViewHolder(holder: ServiciosViewHolder, position: Int) {
            holder.imgServicios.setImageResource(listaServicios[position].img!!)
            holder.txtServicios.text = listaServicios[position].name
      }

      inner class ServiciosViewHolder(binding: ServiciosItemBinding): RecyclerView.ViewHolder(binding.root){

            val imgServicios = binding.imgServicios
            val txtServicios = binding.txtServicio

      }
}