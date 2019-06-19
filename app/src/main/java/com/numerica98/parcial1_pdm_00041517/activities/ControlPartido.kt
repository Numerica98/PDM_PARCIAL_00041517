package com.numerica98.parcial1_pdm_00041517.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.numerica98.parcial1_pdm_00041517.R
import kotlinx.android.synthetic.main.conteo_partido.*

class ControlPartido : AppCompatActivity() {
    var puntosEquipo1: Int=0
    var puntosEquipo2:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.conteo_partido)

        //Control de conteo de canastas para el equipo 1
        bt_1punto_equipo1.setOnClickListener {
            puntosEquipo1= puntosEquipo1 +1
            tv_puntos_equipo1_en_partido.text = puntosEquipo1.toString()
        }

        bt_2puntos_equipo1.setOnClickListener {
            puntosEquipo1= puntosEquipo1 +2
            tv_puntos_equipo1_en_partido.text = puntosEquipo1.toString()
        }

        bt_3puntos_equipo1.setOnClickListener {
            puntosEquipo1= puntosEquipo1 +3
            tv_puntos_equipo1_en_partido.text = puntosEquipo1.toString()
        }

        //Control de conteo de canastas para el equipo 2
        bt_1punto_equipo2.setOnClickListener {
            puntosEquipo2= puntosEquipo2 +1
            tv_puntos_equipo2_en_partido.text = puntosEquipo2.toString()
        }

        bt_2puntos_equipo2.setOnClickListener {
            puntosEquipo2= puntosEquipo2 +2
            tv_puntos_equipo2_en_partido.text = puntosEquipo2.toString()
        }
        bt_3puntos_equipo2.setOnClickListener {
            puntosEquipo2= puntosEquipo2 +3
            tv_puntos_equipo2_en_partido.text = puntosEquipo2.toString()
        }

        bt_finalizo_partido.setOnClickListener {
            var replyIntent = Intent()

            if(TextUtils.isEmpty(et_nombre_equipo1.text)||
                    TextUtils.isEmpty(et_nombre_equipo2.text)||
                    TextUtils.isEmpty(et_hora_partido.text)||
                    TextUtils.isEmpty(et_dia_partido.text)){
                setResult(Activity.RESULT_CANCELED, replyIntent)
            }else {
                val nombreEquipo1 = et_nombre_equipo1.text.toString()
                replyIntent.putExtra(EXTRA_NOMBRE_EQUIPO1, nombreEquipo1)

                val nombreEquipo2 = et_nombre_equipo2.text.toString()
                replyIntent.putExtra(EXTRA_NOMBRE_EQUIPO2, nombreEquipo2)

                val horaPartido = et_hora_partido.text.toString()
                replyIntent.putExtra(EXTRA_HORA, horaPartido)

                val diaPartido = et_dia_partido.text.toString()
                replyIntent.putExtra(EXTRA_FECHA, diaPartido)

                val puntos1 = tv_puntos_equipo1_en_partido.text.toString()
                replyIntent.putExtra(EXTRA_PUNTOS_EQUIPO1, puntos1)

                val puntos2 = tv_puntos_equipo2_en_partido.text.toString()
                replyIntent.putExtra(EXTRA_PUNTOS_EQUIPO2, puntos2)

                if(puntosEquipo1 > puntosEquipo2){
                    replyIntent.putExtra(EXTRA_GANADOR, nombreEquipo1)
                }else if(puntosEquipo2 > puntosEquipo1){
                    replyIntent.putExtra(EXTRA_GANADOR, nombreEquipo2)
                } else if(puntosEquipo1 == puntosEquipo2){
                    replyIntent.putExtra(EXTRA_GANADOR, "Empate")
                }

                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_NOMBRE_EQUIPO1 = "nombre1"
        const val EXTRA_NOMBRE_EQUIPO2 = "nombre2"
        const val EXTRA_HORA = "hora"
        const val EXTRA_FECHA = "dia"
        const val EXTRA_PUNTOS_EQUIPO1 = "puntos1"
        const val EXTRA_PUNTOS_EQUIPO2 = "puntos2"
        const val EXTRA_GANADOR = "ganador"
    }

}