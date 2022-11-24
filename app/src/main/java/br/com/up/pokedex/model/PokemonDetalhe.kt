package br.com.up.pokedex.model
import com.google.gson.annotations.SerializedName

data class PokemonDetalhe(
    val name : String,
    val id: Int,
    val height: Int,
    @SerializedName("abilities")
    val abilities: List<Habilidade>,
    @SerializedName("types")
    val types: List<Tipo>,
    @SerializedName("stats")
    val stats: List<Estatistica>,
    @SerializedName("moves")
    val moves: List<Movimento>
    )
