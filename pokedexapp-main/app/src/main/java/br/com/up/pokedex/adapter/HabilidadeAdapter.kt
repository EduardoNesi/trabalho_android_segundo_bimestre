package br.com.up.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.R
import br.com.up.pokedex.model.Ability
import com.squareup.picasso.Picasso

class HabilidadeAdapter (private val habilidades: List<Ability>) : RecyclerView.Adapter<HabilidadeAdapter.HabilidadeViewHolder>(){

    inner class HabilidadeViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): HabilidadeAdapter.HabilidadeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val layout = layoutInflater.inflate(
            R.layout.habilidades_view,
            parent,
            false
        )

        return HabilidadeViewHolder(layout)
    }

    override fun onBindViewHolder(holder: HabilidadeViewHolder, position: Int) {

        val habilidade = habilidades[position]

        val nome_habilidade : TextView = holder.itemView.findViewById(R.id.habilidade)

        nome_habilidade.setText(habilidade.ability.name)

    }

    override fun getItemCount(): Int {
        return habilidades.size
    }
}