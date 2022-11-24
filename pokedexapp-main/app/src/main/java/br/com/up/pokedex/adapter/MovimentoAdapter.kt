package br.com.up.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.R
import br.com.up.pokedex.model.Ability
import br.com.up.pokedex.model.Move

class MovimentoAdapter (private val movimentos: List<Move>) : RecyclerView.Adapter<MovimentoAdapter.MovimentoViewHolder>(){

    inner class MovimentoViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MovimentoAdapter.MovimentoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val layout = layoutInflater.inflate(
            R.layout.movimentos_view,
            parent,
            false
        )

        return MovimentoViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MovimentoViewHolder, position: Int) {

        val movimento = movimentos[position]

        val nome_movimento : TextView = holder.itemView.findViewById(R.id.movimento)

        nome_movimento.setText(movimento.move.name)

    }

    override fun getItemCount(): Int {
        return movimentos.size
    }
}