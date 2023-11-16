package com.example.ejemplorv

import android.app.Application
import androidx.room.Room
import androidx.room.Room.databaseBuilder

class MisContactosApp: Application() {
    companion object {
        lateinit var database: ContactosDataBase
    }
    override fun onCreate() {
        super.onCreate()
        MisContactosApp.database =  databaseBuilder(this, ContactosDataBase::class.java, "tasks-db").build()
    }
}