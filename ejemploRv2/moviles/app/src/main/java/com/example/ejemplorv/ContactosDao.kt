package com.example.ejemplorv
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ejemplorv.entidades.ContactosEntity

@Dao
interface ContactosDao {
    @Query("SELECT * FROM contactos_entity")
    suspend fun getAllContactos(): MutableList< ContactosEntity>  // Función que devuelve todas los contactos de la base de datos en una lista Mutable.

    @Insert
    suspend fun addContacto (contactosEntity : ContactosEntity):Long    // Función que añade una contacto, la que se pasa por parámetro, y devuelve el id insertado.                                                          // Devuelve Long porque la cantidad de datos guardada puede ser muy alto.



    @Update
    suspend fun updateContacto(contacto: ContactosEntity):Int         // Función que actualiza una cntacto y devuelve

    @Delete
    suspend fun deleteContacto(contacto: ContactosEntity):Int         // Función que borra una contacto y devuelve
}

// @Update

// @Delete

