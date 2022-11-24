package br.com.up.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.R
import br.com.up.pokedex.model.Ability
import br.com.up.pokedex.model.Stat

class EstatisticaAdapter (private val estatisticas: List<Stat>) : RecyclerView.Adapter<EstatisticaAdapter.EstatisticaViewHolder>(){

    inner class EstatisticaViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): EstatisticaAdapter.EstatisticaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val layout = layoutInflater.inflate(
            R.layout.estatistica_view,
            parent,
            false
        )

        return EstatisticaViewHolder(layout)
    }

    override fun onBindViewHolder(holder: EstatisticaViewHolder, position: Int) {

        val estatistica = estatisticas[position]

        val nome_estatistica : TextView = holder.itemView.findViewById(R.id.nomeStat)
        val esforco_estatistica : TextView = holder.itemView.findViewById(R.id.esforcoStat)
        val valor_estatistica : TextView = holder.itemView.findViewById(R.id.valueStat)

        nome_estatistica.setText(estatistica.stat.name)
        esforco_estatistica.setText(estatistica.effort.toString())
        valor_estatistica.setText(estatistica.base_stat.toString())


    }

    override fun getItemCount(): Int {
        return estatisticas.size
    }
}