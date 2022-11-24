package br.com.up.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.R
import br.com.up.pokedex.model.Ability
import br.com.up.pokedex.model.Type

class TipoAdapter (private val tipos: List<Type>) : RecyclerView.Adapter<TipoAdapter.TipoViewHolder>(){

    inner class TipoViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): TipoAdapter.TipoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val layout = layoutInflater.inflate(
            R.layout.tipos_view,
            parent,
            false
        )

        return TipoViewHolder(layout)
    }

    override fun onBindViewHolder(holder: TipoViewHolder, position: Int) {

        val tipo = tipos[position]

        val nome_tipo : TextView = holder.itemView.findViewById(R.id.tipo)

        nome_tipo.setText(tipo.type.name)

    }

    override fun getItemCount(): Int {
        return tipos.size
    }
}