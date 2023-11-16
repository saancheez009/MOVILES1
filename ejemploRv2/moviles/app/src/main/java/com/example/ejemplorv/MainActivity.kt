package com.example.ejemplorv

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplorv.databinding.ContactosBinding
import com.example.ejemplorv.entidades.ContactosEntity
import kotlinx.coroutines.launch
import com.example.ejemplorv.ContactosDao
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {

        lateinit var recyclerView: RecyclerView
        lateinit var adapter: ContactosAdapter
        lateinit var tasks: MutableList<ContactosEntity>
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contactos = ContactosBinding.inflate(layoutInflater)
        setContentView(contactos.root)

//Lista de contactos
        contactos.vistaContactos.adapter=ContactosAdapter(listOf(
            Contacto("Juan","648362245",  "hombre"),
            Contacto("Jorge","648362245", "hombre"),
            Contacto("Sheila","648362245","mujer"),
            Contacto("Juana","648365465","mujer"),
            Contacto("Carla","648362245","mujer"),
            Contacto("Marta","644892245","mujer"),
            Contacto("Paco","648362456","mujer"),
            Contacto("Fabián","636962245","hombre"),
            Contacto("Jonathan","123362245","hombre"/*"htttps"+(100+Math.random().toInt())*/),
            Contacto("Erick","612362245","hombre"),
            Contacto("Sandra","648362789","mujer"),
            Contacto("Leo","6483625436","hombre"),
            Contacto("Messi","648365642","hombre")
        )
            ,
            object : ContactoPulsadoListener{
                override fun contactoPulsado(contacto: Contacto) {
                    val dial= Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+contacto.telefono))
                    startActivity(dial)

                   // val view =Intent(Intent.ACTION_VIEW, Uri.parse("name:"+contacto.nombre.get(0)) )
              // startActivity(view)
                }
            }
        )


    }

    fun getContactos()= runBlocking {
        launch {                        // Inicio del hilo
            var contactos = MisContactosApp.database.contactosDao().getAllContactos()    // Se carga la lista de contactos
            setUpRecyclerView(contactos)        // se pasa la lista a la Vista
        }
    }

    fun addContacto(contacto:ContactosEntity)= runBlocking{  // Corrutina que añade un contacto
        launch {
            val contactos = ContactosBinding.inflate(layoutInflater)
            val id = MisContactosApp.database.contactosDao().addContacto(contacto)   // Inserta un contacto
            val recoveryContacto = MisContactosApp.database.contactosDao().getAllContactos()   // Recarga la lista de contacts
            contactos.add(recoveryContacto)
            adapter.notifyItemInserted(contactos.size)  // El adaptador notifica que se ha insertado
                // y se oculta el teclado
        }
    }


    fun deleteContacto(contacto: ContactosEntity)= runBlocking{
        launch {
            val position = contactos.indexOf(contacto)  // Busca la posición del contacto en la lista...
            MisContactosApp.database.contactosDao().deleteContacto(contacto) // ... y lo borra de la base de datos.
            contactos.remove(contacto)      // Finalmente, la elimina el contacto de la lista
            adapter.notifyItemRemoved(position) // El adaptador notifica que se ha eliminado el contacto
        }
    }

    fun setUpRecyclerView(contactos: List< ContactosEntity>) {    // Método que muestra la vista usando el adaptador
        adapter = ContactosAdapter(contactos, { updateContacto(it) }, {deleteContacto(it)})
        recyclerView = findViewById(R.id.rvContacto)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}