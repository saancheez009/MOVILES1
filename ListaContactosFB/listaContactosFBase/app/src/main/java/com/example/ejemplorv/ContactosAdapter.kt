package com.example.ejemplorv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplorv.databinding.ItemContactoBinding

class ContactosAdapter(
    private val contactos: List<Contacto>,
    private val contactoPulsadoListener:ContactoPulsadoListener)

    :RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemContactoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(contacto: Contacto) {

            binding.nombre.text=contacto.nombre
            binding.telefono.text= contacto.telefono

            //imagen si es hombre o mujer
            if(contacto.gender=="mujer"){
                binding.fotoContacto.setImageResource(R.drawable.mujer)
            }else {
                binding.fotoContacto.setImageResource(R.drawable.hombre)
            }

            binding.inicial.text=contacto.nombre.get(0).toString()
            val inicial=binding.inicial.text
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding =
            ItemContactoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int /*=contactos.size*/ {


        return contactos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactos[position])
        //separamos los nombres y apellidos
        //palabras por separado
        var palabras= contactos[position].nombre.split(" ")
        //iniciales
        var inic=" "
        //recorremos los nombres para sacar las iniciales
        for (palabra in palabras){
            //primera letra de cada palabra , se inicia en 0 hasta el 1 que es la primera letra
            inic+=palabra.substring(0,1)
        }
        //Pasamos inicales a mayúscula
        holder.binding.inicial.text = inic.uppercase()
        //se muestra el contacto
        holder.bind(contactos[position])

        //inicial visible o invisible al pulsar imagen
        holder.binding.fotoContacto.setOnClickListener {
            if (holder.binding.inicial.isVisible) {
                holder.binding.inicial.visibility = View.INVISIBLE
                holder.binding.nombre.visibility= View.VISIBLE
                holder.binding.telefono.visibility= View.VISIBLE

            } else {

                holder.binding.inicial.visibility = View.VISIBLE
                holder.binding.nombre.visibility= View.INVISIBLE
                holder.binding.telefono.visibility= View.INVISIBLE

            }
        }

        holder.itemView.setOnClickListener(){
          contactoPulsadoListener.contactoPulsado(contactos[position])
        }
    }

}
