package com.numerica98.parcial1_pdm_00041517.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.numerica98.parcial1_pdm_00041517.data.RoomDB
import com.numerica98.parcial1_pdm_00041517.data.entities.Partido
import com.numerica98.parcial1_pdm_00041517.repository.PartidoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PartidoViewModel (app: Application) : AndroidViewModel(app) {

    private val repository: PartidoRepository

    init {
        val partidoDao= RoomDB.getInstance(app).partidoDao()
        repository = PartidoRepository(partidoDao)
    }

    fun insert(partido:Partido)= viewModelScope.launch(Dispatchers.IO){
        repository.insert(partido)
    }

    fun getAll(): LiveData<List<Partido>> = repository.getAll()

    //fun getPartido(): LiveData<Partido> = repository.getOne()

    fun delete()= repository.delete()

}