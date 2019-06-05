package com.numerica98.parcial1_pdm_00041517.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "partidos")
data class Partido(
    @ColumnInfo(name = "nombre_equipo1") var nombre_equipo1: String,
    @ColumnInfo(name = "nombre_equipo2") var nombre_equipo2: String,
    @ColumnInfo(name = "puntos_equipo1") var puntos_equipo1: Int,
    @ColumnInfo(name = "puntos_equipo2") var puntos_equipo2: Int,
    @ColumnInfo(name = "hora") var hora: String,
    @ColumnInfo(name = "fecha") var fecha: String,
    @ColumnInfo(name = "ganador") var ganador: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}

