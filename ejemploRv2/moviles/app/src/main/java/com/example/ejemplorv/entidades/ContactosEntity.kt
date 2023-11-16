package com.example.ejemplorv.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contactos_entity")
data class ContactosEntity(
    @PrimaryKey(autoGenerate = true)
    var name:String = "",
    var tel:String = "",
    var gender:String=""
)