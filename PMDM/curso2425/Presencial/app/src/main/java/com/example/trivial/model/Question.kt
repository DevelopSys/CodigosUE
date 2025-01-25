package com.example.trivial.model

data class Question (

    val type: String? = null,
    val difficulty: String? = null,
    val category: String? = null,
    val question: String? = null,
    val correctAnswer: String? = null,
    val incorrectAnswers: List<String>? = null
){

    // codigo que se ejecute tras el constructor
    init {
        
    }

}
