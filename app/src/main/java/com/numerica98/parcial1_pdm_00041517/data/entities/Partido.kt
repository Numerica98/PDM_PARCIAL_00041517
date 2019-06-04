package com.numerica98.parcial1_pdm_00041517.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "partidos")
data class Partido(
    @ColumnInfo(name= "atributos")
    val nombre_equipo1:String,
    val nombre_equipo2:String,
    val puntos_equipo1:Int,
    val puntos_equipo2:Int,
    val hora:String,
    val fecha:String,
    val ganador:String
){
    @PrimaryKey (autoGenerate = true)
        val id:Int=0
    }

