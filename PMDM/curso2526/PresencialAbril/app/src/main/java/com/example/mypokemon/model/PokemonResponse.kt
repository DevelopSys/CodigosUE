package com.example.mypokemon.model

data class PokemonResponse (
    val count: Long,
    val next: String,
    val previous: Any? = null,
    val results: List<Result>
)

data class Result (
    val name: String,
    val url: String
)
