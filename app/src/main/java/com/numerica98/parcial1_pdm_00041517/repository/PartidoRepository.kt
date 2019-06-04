package com.numerica98.parcial1_pdm_00041517.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.numerica98.parcial1_pdm_00041517.data.daos.PartidoDAO
import com.numerica98.parcial1_pdm_00041517.data.entities.Partido

class PartidoRepository (private val partidoDao: PartidoDAO) {

    @WorkerThread
    suspend fun insert(partido:Partido){
        partidoDao.insert(partido)
    }


    fun getAll(): LiveData<List<Partido>> = partidoDao.getAllPartidos()
    /*
    * fun getOne(): LiveData<Partido> = partido.getPartido(idAConsultar)
    * */

    fun delete() = partidoDao.delete()
}