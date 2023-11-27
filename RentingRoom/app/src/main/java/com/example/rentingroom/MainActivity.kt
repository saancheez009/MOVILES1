package com.example.rentingroom

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.rentingroom.databinding.ActivityMainBinding
import com.example.rentingroom.databinding.HabitacionesBinding
import com.example.rentingroom.databinding.InfoBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val MainBinding = ActivityMainBinding.inflate(layoutInflater)
        val infoBinding = InfoBinding.inflate(layoutInflater)
        val habitacionesBinding= HabitacionesBinding.inflate(layoutInflater)

        setContentView(MainBinding.root)

        val infoBoton = MainBinding.infoBtn

        val habitacionesBoton = MainBinding.habitacionesBtn

        infoBoton.setOnClickListener(View.OnClickListener {

                setContentView(infoBinding.root)
        })
        habitacionesBoton.setOnClickListener(View.OnClickListener {

            setContentView(habitacionesBinding.root)

        })

        infoBinding.infoBtn.setOnClickListener(View.OnClickListener {

            setContentView(infoBinding.root)
        })
        infoBinding.habitacionesBtn.setOnClickListener(View.OnClickListener {

            setContentView(habitacionesBinding.root)
            habitacionesBinding.vistaHabitaciones.adapter=HabitacionesAdapter(listOf(
                Habitaciones("1","paraiso","1/5/22"),
                Habitaciones("2","butterfly","1/5/22"),
                Habitaciones("3","sunshine","1/5/22"),
                Habitaciones("4","amapola","1/5/22"),
                Habitaciones("5","margarita","1/5/22"),
                Habitaciones("6","marface","1/5/22"),
                Habitaciones("7","movile","1/5/22"),
                Habitaciones("8","fear","1/5/22"),
                Habitaciones("9","paraiso2","1/5/22"),
                Habitaciones("10","paraiso3","1/5/22"),


            )
                ,
                object : HabitacionPulsadaListener{
                    override fun habitacionPulsada(habitacion: Habitaciones) {
                        TODO("Not yet implemented")


                }

        })
        habitacionesBinding.infoBtn.setOnClickListener(View.OnClickListener {

            setContentView(infoBinding.root)
        })
        habitacionesBinding.habitacionesBtn.setOnClickListener(View.OnClickListener {

            setContentView(habitacionesBinding.root)
        })

    //barraInfo()
    //barraHab()

    }


/*private fun barraInfo () {
    val MainBinding = ActivityMainBinding.inflate(layoutInflater)
    val infoBinding = InfoBinding.inflate(layoutInflater)
    val habitacionesBinding = HabitacionesBinding.inflate(layoutInflater)
    infoBinding.infoBtn.setOnClickListener(View.OnClickListener {

        setContentView(infoBinding.root)
    })
    infoBinding.habitacionesBtn.setOnClickListener(View.OnClickListener {

        setContentView(habitacionesBinding.root)
    })

}

    private fun barraHab () {
        val MainBinding = ActivityMainBinding.inflate(layoutInflater)
        val infoBinding = InfoBinding.inflate(layoutInflater)
        val habitacionesBinding = HabitacionesBinding.inflate(layoutInflater)
        habitacionesBinding.infoBtn.setOnClickListener(View.OnClickListener {

            setContentView(infoBinding.root)
        })
        habitacionesBinding.habitacionesBtn.setOnClickListener(View.OnClickListener {

            setContentView(habitacionesBinding.root)
        })

    }*/
}