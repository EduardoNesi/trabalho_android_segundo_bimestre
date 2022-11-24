package br.com.up.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.adapter.*
import br.com.up.pokedex.model.Ability
import br.com.up.pokedex.model.Move
import br.com.up.pokedex.model.Stat
import br.com.up.pokedex.model.Type
import br.com.up.pokedex.network.PokeApi
import com.squareup.picasso.Picasso

class PokemonDetailsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val pokemon_name = intent.getStringExtra("pokemon")

        var nomePokemon: TextView = findViewById<View>(R.id.nomePokemon) as TextView
        var imagemPoke: ImageView = findViewById<View>(R.id.imagemPoke) as ImageView
        var alturaPokemon : TextView = findViewById<View>(R.id.altura) as TextView

        val habilidaderecyclerView : RecyclerView
                = findViewById(R.id.habilidadesRecycler)

        habilidaderecyclerView.layoutManager = GridLayoutManager(this, 3)

        val tiporecyclerView : RecyclerView
                = findViewById(R.id.tiposRecycler)

        tiporecyclerView.layoutManager = GridLayoutManager(this, 3)

        val movimentorecyclerView : RecyclerView
                = findViewById(R.id.movimentosRecycler)

        movimentorecyclerView.layoutManager = GridLayoutManager(this, 3)

        val estatisticarecyclerView : RecyclerView
                = findViewById(R.id.estatisticaRecycler)

        estatisticarecyclerView.layoutManager = GridLayoutManager(this, 1)


        PokeApi().getPokemonByName(pokemon_name!!){
                pokemon ->

            if(pokemon != null){
                nomePokemon.setText(pokemon.name)
                alturaPokemon.setText(pokemon.height.toString())
                //https://pokeapi.co/api/v2/pokemon/1/"
                val id = pokemon.id

                val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"

                Picasso.get().load(url).into(imagemPoke)

                //listando as habilidades e passando para serem listadas na tela
                var list_abilities : List<Ability> = pokemon.abilities
                habilidaderecyclerView.adapter = HabilidadeAdapter(list_abilities!!)

                var list_types : List<Type> = pokemon.types
                tiporecyclerView.adapter = TipoAdapter(list_types)

                var list_moves : List<Move> = pokemon.moves
                movimentorecyclerView.adapter = MovimentoAdapter(list_moves)

                var list_stats : List<Stat> = pokemon.stats
                estatisticarecyclerView.adapter = EstatisticaAdapter(list_stats)

            }
        }

    }
}