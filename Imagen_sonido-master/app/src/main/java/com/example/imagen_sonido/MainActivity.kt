package com.example.imagen_sonido

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.imagen_sonido.databinding.ActivityMainBinding
import com.example.tarea5_1.R
import com.example.tarea5_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    private var gato: ImageButton? = null
    private var asno: ImageButton? = null
    private var perro: ImageButton? = null
    private var mediaplayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)
        mediaplayer = MediaPlayer.create(this, R.raw.gato)
        //Obtenemos los tres botones de la interfaz
        gato = findViewById(R.id.gatito)
        perro = findViewById(R.id.perrito)
        asno = findViewById(R.id.asno)
        //Y les asignamos el controlador de eventos
        gato!!.setOnClickListener(this);
        perro!!.setOnClickListener(this);
        asno!!.setOnClickListener(this);
    }

    override fun onClick(v: View) {

        when (v.getId()) {
            R.id.gatito -> {
                //Inicia el audio
                mediaplayer = MediaPlayer.create(this, R.raw.gato)
                mediaplayer!!.start()
            }

            R.id.perrito -> {
                //Inicia el audio
                mediaplayer = MediaPlayer.create(this, R.raw.perro)
                mediaplayer!!.start()
            }

            R.id.asno -> {
                //Inicia el audio
                mediaplayer = MediaPlayer.create(this, R.raw.asno)
                mediaplayer!!.start()
            }
        }
    }
}