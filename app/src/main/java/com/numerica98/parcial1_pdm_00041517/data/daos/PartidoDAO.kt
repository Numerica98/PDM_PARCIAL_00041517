package com.numerica98.parcial1_pdm_00041517.data.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.numerica98.parcial1_pdm_00041517.data.entities.Partido

@Dao
interface PartidoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(partido: Partido)

    @Query("SELECT * FROM partidos") //Mostrar todos los registros, solo es para verificar que guarda todos los datos
    fun getAllPartidos(): LiveData<List<Partido>>

    @Query("SELECT * FROM partidos WHERE id =:idAConsultar") //Mostrar un elemento en especifico, arreglar
    fun getPartido(idAConsultar: Int): LiveData<Partido>

    @Query("DELETE FROM partidos")
    fun delete()

}