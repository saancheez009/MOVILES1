package com.example.ejemplorv

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemplorv.databinding.ContactosBinding
import com.google.firebase.analytics.FirebaseAnalytics


class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contactos = ContactosBinding.inflate(layoutInflater)
        setContentView(contactos.root)


        contactos.vistaContactos.adapter=ContactosAdapter(listOf(
        Contacto(1,"Juan","648362245",  "hombre"),
        Contacto(2,"Jorge","648362245", "hombre"),
        Contacto(3,"Sheila","648362245","mujer"),
        Contacto(4,"Juana","648365465","mujer"),
        Contacto(5,"Carla","648362245","mujer"),
        Contacto(6,"Marta","644892245","mujer"),
        Contacto(7,"Paco","648362456","mujer"),
        Contacto(8,"Fabián","636962245","hombre"),
        Contacto(9,"Jonathan","123362245","hombre"/*"htttps"+(100+Math.random().toInt())*/),
        Contacto(10,"Erick","612362245","hombre"),
        Contacto(11,"Sandra","648362789","mujer"),
        Contacto(12,"Leo","6483625436","hombre"),
        Contacto(13,"Messi","648365642","hombre")
        )
            ,
            object : ContactoPulsadoListener{
                override fun contactoPulsado(contacto: Contacto) {
                    val dial= Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+contacto.telefono))
                    startActivity(dial)


                }
            }
        )
        val analytics :FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle= Bundle()

        bundle.putString("message", "Integración de Firebase completa")
        analytics.logEvent("InitScreen",bundle)

    }
}