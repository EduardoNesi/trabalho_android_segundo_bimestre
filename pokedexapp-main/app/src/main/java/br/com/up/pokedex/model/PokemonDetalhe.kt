package br.com.up.pokedex.model
import com.google.gson.annotations.SerializedName

data class PokemonDetalhe(
    val name : String,
    val id: Int,
    val height: Int,
    @SerializedName("abilities")
    val abilities: List<Ability>,
    @SerializedName("types")
    val types: List<Type>,
    @SerializedName("stats")
    val stats: List<Stat>,
    @SerializedName("moves")
    val moves: List<Move>
    )
