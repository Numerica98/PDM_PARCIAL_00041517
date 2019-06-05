package com.numerica98.parcial1_pdm_00041517.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "partidos")
data class Partido(
        @ColumnInfo(name= "nombre_equipo1") val nombre_equipo1:String,
        @ColumnInfo(name= "nombre_equipo2") val nombre_equipo2:String,
        @ColumnInfo(name= "puntos_equipo1") val puntos_equipo1:Int,
        @ColumnInfo(name= "puntos_equipo2") val puntos_equipo2:Int,
        @ColumnInfo(name= "hora") val hora:String,
        @ColumnInfo(name= "fecha") val fecha:String,
        @ColumnInfo(name= "ganador") val ganador:String
){
    @PrimaryKey (autoGenerate = true)
        val id:Int=0
    }

