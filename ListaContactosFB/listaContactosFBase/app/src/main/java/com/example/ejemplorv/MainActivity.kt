package com.example.ejemplorv

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemplorv.databinding.ContactosBinding



class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contactos = ContactosBinding.inflate(layoutInflater)
        setContentView(contactos.root)


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


                }
            }
        )


    }
}