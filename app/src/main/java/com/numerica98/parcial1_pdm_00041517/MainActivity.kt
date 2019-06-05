package com.numerica98.parcial1_pdm_00041517

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.conteo_partido.*

class MainActivity : AppCompatActivity() {

    var cont1: Int=0
    //var cont2:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.conteo_partido)

        bt_1punto_equipo1.setOnClickListener {
            cont1= cont1 +1
            tv_puntos_equipo1_en_partido.text = cont1.toString()
        }
    }
}
