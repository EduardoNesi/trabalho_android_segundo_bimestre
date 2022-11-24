package br.com.up.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.adapter.*
import br.com.up.pokedex.model.Habilidade
import br.com.up.pokedex.model.Movimento
import br.com.up.pokedex.model.Estatistica
import br.com.up.pokedex.model.Tipo
import br.com.up.pokedex.network.PokeApi
import com.squareup.picasso.Picasso

class PokemonDetailsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val pokemon_name = intent.getStringExtra("pokemon")



        val habilidade_recyclerView : RecyclerView
                = findViewById(R.id.tiposRecycler)

        habilidade_recyclerView.layoutManager = GridLayoutManager(this, 3)

        val tipo_recyclerView : RecyclerView
                = findViewById(R.id.habilidadesRecycler)

        tipo_recyclerView.layoutManager = GridLayoutManager(this, 3)

        val movimento_recyclerView : RecyclerView
                = findViewById(R.id.movimentosRecycler)

        movimento_recyclerView.layoutManager = GridLayoutManager(this, 3)

        val estatistica_recyclerView : RecyclerView
                = findViewById(R.id.estatisticaRecycler)

        estatistica_recyclerView.layoutManager = GridLayoutManager(this, 1)

        var nome_Pokemon: TextView = findViewById<View>(R.id.nomePokemon) as TextView
        var imagem_Poke: ImageView = findViewById<View>(R.id.imagemPoke) as ImageView
        var altura_Pokemon : TextView = findViewById<View>(R.id.altura) as TextView

        PokeApi().getPokemonByName(pokemon_name!!){
                pokemon ->

            if(pokemon != null){
                nome_Pokemon.setText(pokemon.name)
                altura_Pokemon.setText(pokemon.height.toString())
                //https://pokeapi.co/api/v2/pokemon/1/"
                val id = pokemon.id

                val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"

                Picasso.get().load(url).into(imagem_Poke)

                var list_abilities : List<Habilidade> = pokemon.abilities
                habilidade_recyclerView.adapter = HabilidadeAdapter(list_abilities!!)

                var list_types : List<Tipo> = pokemon.types
                tipo_recyclerView.adapter = TipoAdapter(list_types)

                var list_moves : List<Movimento> = pokemon.moves
                movimento_recyclerView.adapter = MovimentoAdapter(list_moves)

                var list_stats : List<Estatistica> = pokemon.stats
                estatistica_recyclerView.adapter = EstatisticaAdapter(list_stats)

            }
        }

    }
}