package com.numerica98.parcial1_pdm_00041517

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.numerica98.parcial1_pdm_00041517.data.entities.Partido
import kotlinx.android.synthetic.main.item_partido.view.*

class PartidoAdapter internal constructor(context:Context, val clickListener:(Partido)-> Unit): RecyclerView.Adapter<PartidoAdapter.PartidoViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var partidos = emptyList<Partido>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartidoViewHolder {
        val itemView = inflater.inflate(R.layout.item_partido, parent, false)
        return  PartidoViewHolder(itemView)
    }

    override fun getItemCount(): Int = partidos.size

    override fun onBindViewHolder(holder: PartidoViewHolder, position: Int) = holder.bind(partidos[position], clickListener)

    fun cambioLista(partidos: List<Partido>){
        this.partidos = partidos
        notifyDataSetChanged()
    }

    inner class PartidoViewHolder(var view: View): RecyclerView.ViewHolder(view) {
        fun bind(itemPartido:Partido, clickListener:(Partido)->Unit)= with(view){
            tv_nombre_equipo1_item.text= itemPartido.nombre_equipo1
            tv_nombre_equipo2_item.text= itemPartido.nombre_equipo2

        }

    }
}