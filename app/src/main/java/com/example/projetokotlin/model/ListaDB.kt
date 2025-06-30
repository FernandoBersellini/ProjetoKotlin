package com.example.projetokotlin.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projetokotlin.model.dao.ListasDAO
import com.example.projetokotlin.model.entity.Afazeres
import com.example.projetokotlin.model.entity.Lista

@Database(entities = [Lista::class, Afazeres::class], version = 1)
abstract class ListaDB: RoomDatabase() {
    abstract fun listaDao() : ListasDAO

    companion object {
        @Volatile
        private var INSTANCE: ListaDB? = null

        fun getDatabase(context: Context): ListaDB {
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ListaDB::class.java,
                    "bancoDeListas"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}