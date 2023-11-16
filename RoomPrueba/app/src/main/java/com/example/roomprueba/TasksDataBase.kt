package com.example.roomprueba

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomprueba.entidades.TaskEntity

@Database(entities = arrayOf(TaskEntity::class), version = 1)


abstract class TasksDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
