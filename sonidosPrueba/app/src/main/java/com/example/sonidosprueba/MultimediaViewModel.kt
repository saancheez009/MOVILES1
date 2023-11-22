package com.example.sonidosprueba

import android.media.MediaPlayer
import androidx.lifecycle.ViewModel
class MultimediaViewModel : ViewModel() {
    private var mediaPlayer: MediaPlayer? = null

    fun initialize(context: android.content.Context) {
        mediaPlayer = MediaPlayer.create(context, R.raw.cancion)
    }

    fun play() {
        mediaPlayer?.start()
    }

    fun pause() {
        mediaPlayer?.pause()
    }

    fun stop() {
        mediaPlayer?.apply {
            stop()
            prepare()
            seekTo(0)
        }
    }

    override fun onCleared() {
        mediaPlayer?.release()
        super.onCleared()
    }
}




