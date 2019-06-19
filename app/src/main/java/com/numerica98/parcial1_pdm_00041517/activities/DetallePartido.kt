package com.numerica98.parcial1_pdm_00041517.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.numerica98.parcial1_pdm_00041517.R
import com.numerica98.parcial1_pdm_00041517.data.entities.Partido
import kotlinx.android.synthetic.main.detalle_partido.*

class DetallePartido : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalle_partido)

        val partidoEntrante : Partido? = intent.extras.getParcelable("PARTIDO")

        if (partidoEntrante != null){
            init(partidoEntrante)
        }
    }

    fun init(partido: Partido){
        tv_nombre_equipo1_titulo.text = partido.nombre_equipo1
        tv_nombre_equipo2_titulo.text = partido.nombre_equipo2

        tv_nombre_equipo1.text = partido.nombre_equipo1
        tv_nombre_equipo2.text = partido.nombre_equipo2
        tv_puntos_equipo1.text = partido.puntos_equipo1
        tv_puntos_equipo2.text = partido.puntos_equipo2
        tv_fecha_partido.text = partido.fecha
        tv_hora_partido.text = partido.hora
        tv_nombre_equipo_ganador.text = partido.ganador

    }
}