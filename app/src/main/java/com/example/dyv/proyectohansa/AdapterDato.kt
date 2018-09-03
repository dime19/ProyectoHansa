package com.example.dyv.proyectohansa

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_dato.view.*
import java.util.ArrayList

class AdapterDato (val lista: ArrayList<Dato>, val context: Context):
    RecyclerView.Adapter<AdapterDato.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_dato,parent,false))
        }

        override fun getItemCount(): Int {
            return lista.size
        }

        override fun onBindViewHolder(holder:ViewHolder, position: Int) {

            holder.te.text = lista[position].texto
            holder.lati.text=lista[position].latitud
            holder.longi.text=lista[position].longitud
            holder.img.text = lista[position].imagen
        }

        class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
            val img=view.img_dato
            val te=view.texto_dato
            val lati=view.latitud_dato
            val longi=view.longitud_dato

        }
}