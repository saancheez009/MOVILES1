package com.example.ejemplorv

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ejemplorv.entidades.ContactosEntity

@Database(entities = arrayOf(ContactosEntity::class), version = 1)


abstract class ContactosDataBase : RoomDatabase() {
    abstract fun contactosDao(): ContactosDao
}