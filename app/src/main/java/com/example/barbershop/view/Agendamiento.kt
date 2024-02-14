package com.example.barbershop.view

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.example.barbershop.databinding.ActivityAgendamientoBinding

import com.google.android.material.snackbar.Snackbar
import java.util.Calendar

class Agendamiento : AppCompatActivity() {

    private lateinit var binding: ActivityAgendamientoBinding
    private val calendar: Calendar = Calendar.getInstance()
    private var data: String= ""
    private var hora: String= ""

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendamientoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val name = intent.extras?.getString("nombre").toString()

        val datePicker = binding.datePicker
        datePicker.setOnDateChangedListener{ _, year , monthOfYear, dayOfMonth ->

            calendar.set(Calendar.YEAR,year)
            calendar.set(Calendar.MONTH,monthOfYear)
            calendar.set(Calendar.DAY_OF_YEAR,dayOfMonth)

            var dia = dayOfMonth.toString()
            val mes: String

            if (dayOfMonth < 10){
                dia = "0$dayOfMonth"
            }
            if (monthOfYear < 10){
                mes = "" + (monthOfYear + 1)
            }else{
                mes = (monthOfYear +1 ).toString()
            }

            data = "$dia / $mes /$year"

        }
          binding.timePicker.setOnTimeChangedListener { _, hourOfDay, minute ->
              val minuto : String

              if (minute <10){
                  minuto = "0$minute"
              }else{
                  minuto = minute.toString()
              }

                hora = "$hourOfDay:$minuto"
          }
            binding.timePicker.setIs24HourView(true)

            binding.btAgenda.setOnClickListener{

                 val barbero1 = binding.barbero1
                 val barbero2 = binding.barbero2
                 val barbero3 = binding.barbero3

              when{
                  hora.isEmpty() -> {
                      mensagge(it,"Completar el horario","#FF0000")
                  }
                  hora < "8:00" && hora > "19:00" -> {
                      mensagge(it,"lA Barberia esta cerrada - Horario de apertura de 8:00 a 19:00!","#FF0000")

                  }
                  data.isEmpty() -> {
                      mensagge(it,"Poner una fecha!","#FF0000")
                  }
                  barbero1.isChecked  && data.isNotEmpty() && hora.isNotEmpty() ->{
                      mensagge(it,"Cita completada exitosamente!","#FF03DAC5")
                  }
                  barbero2.isChecked  && data.isNotEmpty() && hora.isNotEmpty() ->{
                      mensagge(it,"Cita completada exitosamente!","#FF03DAC5")
                  }
                  barbero3.isChecked  && data.isNotEmpty() && hora.isNotEmpty() ->{
                      mensagge(it,"Cita completada exitosamente!","#FF03DAC5")
                  }

                  else -> {
                      mensagge(it,"Elije un barbero","#FF0000")
                  }
              }
            }
    }

    private fun mensagge(view: View, mensagge: String, cor:String){
        val snackbar = Snackbar.make(view,mensagge,Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor(cor))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()

    }
}