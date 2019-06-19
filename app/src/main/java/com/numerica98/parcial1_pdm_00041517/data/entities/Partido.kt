package com.numerica98.parcial1_pdm_00041517.data.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "partidos")
data class Partido(
    @ColumnInfo(name = "nombre_equipo1") var nombre_equipo1: String,
    @ColumnInfo(name = "nombre_equipo2") var nombre_equipo2: String,
    @ColumnInfo(name = "puntos_equipo1") var puntos_equipo1: String,
    @ColumnInfo(name = "puntos_equipo2") var puntos_equipo2: String,
    @ColumnInfo(name = "hora") var hora: String,
    @ColumnInfo(name = "fecha") var fecha: String,
    @ColumnInfo(name = "ganador") var ganador: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        nombre_equipo1 = parcel.readString(),
        nombre_equipo2 = parcel.readString(),
        puntos_equipo1 = parcel.readString(),
        puntos_equipo2 = parcel.readString(),
        hora = parcel.readString(),
        fecha = parcel.readString(),
        ganador = parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre_equipo1)
        parcel.writeString(nombre_equipo2)
        parcel.writeString(puntos_equipo1)
        parcel.writeString(puntos_equipo2)
        parcel.writeString(hora)
        parcel.writeString(fecha)
        parcel.writeString(ganador)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<Partido> {
        override fun createFromParcel(parcel: Parcel): Partido = Partido(parcel)
        override fun newArray(size: Int): Array<Partido?> = arrayOfNulls(size)
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}

