package com.example.projetokotlin.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projetokotlin.model.dao.ListasDAO
import com.example.projetokotlin.model.entity.Afazeres
import com.example.projetokotlin.model.entity.Lista

@Database(entities = [Lista::class, Afazeres::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun listaDao() : ListasDAO
}