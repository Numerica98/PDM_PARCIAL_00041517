package com.numerica98.parcial1_pdm_00041517.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.numerica98.parcial1_pdm_00041517.R
import com.numerica98.parcial1_pdm_00041517.adapter.PartidoAdapter
import com.numerica98.parcial1_pdm_00041517.data.entities.Partido
import com.numerica98.parcial1_pdm_00041517.viewmodel.PartidoViewModel

class MainActivity : AppCompatActivity() {
    private val newPartidoActivityRequestCode = 1
    private lateinit var partidoViewModel: PartidoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Recyclerview
        val recyclerView = findViewById<RecyclerView>(R.id.rv_partidos)
        val adapter = PartidoAdapter(this, {partido: Partido -> obtenerPartido(partido)})
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //ViewModel
        partidoViewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)

        partidoViewModel.getAll().observe(this, Observer { partidos ->
            partidos?.let { adapter.cambioLista(it) }
        })

        //Boton para crear nuevo partido
        val button = findViewById<Button>(R.id.bt_agregar)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, ControlPartido::class.java)
            startActivityForResult(intent, newPartidoActivityRequestCode)
        }
    }

    private fun obtenerPartido(partido: Partido){
        val partidoBundle = Bundle()
        partidoBundle.putParcelable("PARTIDO", partido)
        startActivity(Intent(this, DetallePartido::class.java).putExtras(partidoBundle))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newPartidoActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let { data ->
                val partido = Partido(data.getStringExtra(ControlPartido.EXTRA_NOMBRE_EQUIPO1),
                        data.getStringExtra(ControlPartido.EXTRA_NOMBRE_EQUIPO2),
                        data.getStringExtra(ControlPartido.EXTRA_PUNTOS_EQUIPO1),
                        data.getStringExtra(ControlPartido.EXTRA_PUNTOS_EQUIPO2),
                        data.getStringExtra(ControlPartido.EXTRA_HORA),
                        data.getStringExtra(ControlPartido.EXTRA_FECHA),
                        data.getStringExtra(ControlPartido.EXTRA_GANADOR)
                )
                partidoViewModel.insert(partido)
            }
        } else {
            Toast.makeText(
                    applicationContext,
                    "No se pudo guardar el partido",
                    Toast.LENGTH_LONG
            ).show()
        }
    }
}