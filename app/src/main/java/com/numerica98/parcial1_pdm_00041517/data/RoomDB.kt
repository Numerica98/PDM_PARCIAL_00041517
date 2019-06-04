package com.numerica98.parcial1_pdm_00041517.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.numerica98.parcial1_pdm_00041517.data.daos.PartidoDAO
import com.numerica98.parcial1_pdm_00041517.data.entities.Partido

@Database(entities = [Partido::class], version = 1, exportSchema = false)
abstract class RoomDB: RoomDatabase() {
    abstract fun partidoDao(): PartidoDAO

    companion object {
        private var INSTANCE: RoomDB? = null

        fun getInstance(AppContext: Context): RoomDB {
            val temInstance = INSTANCE

            //Revisa si ya existe para devolver esa instancia, porque si viene null crea la base de datos
            if (temInstance != null) return temInstance
            synchronized(this){ //Sincroniza lo que se crea en diferentes hilos
                val instance = Room //Manda a llamar Room...
                    .databaseBuilder(AppContext, RoomDB::class.java, "PartidoDB") //... hacia el punto databaseBuilder del objeto Room y le pasa: el AppContext que se tiene en el getInsntance, la clase archivo en la que estoy y un nombre para la base de datos
                    .build()//Construye una referencia a la base de datos ya creada
                INSTANCE = instance
                return instance //Solo la retorno

            }
        }
    }

}