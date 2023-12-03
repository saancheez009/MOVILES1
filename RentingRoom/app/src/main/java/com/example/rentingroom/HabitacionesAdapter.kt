package com.example.rentingroom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rentingroom.databinding.ItemHabitacionBinding

class HabitacionesAdapter (private val habitaciones: List<Habitaciones>,
                           private val HabitacionPulsadaListener:HabitacionPulsadaListener)
    : RecyclerView.Adapter<HabitacionesAdapter.ViewHolder>() {

        class ViewHolder(private val binding: ItemHabitacionBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(habitacion: Habitaciones) {
                binding.numero.text=habitacion.numero

                binding.nombre.text=habitacion.nombre

                binding.fecha.text= habitacion.fecha

            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

            val binding =
                ItemHabitacionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }

        override fun getItemCount(): Int /*=contactos.size*/ {


            return habitaciones.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(habitaciones[position])

            holder.itemView.setOnClickListener(){
                HabitacionPulsadaListener.habitacionPulsada(habitaciones[position])
            }
        }

    }

