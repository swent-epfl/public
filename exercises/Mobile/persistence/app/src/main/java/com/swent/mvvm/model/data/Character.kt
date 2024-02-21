package com.swent.mvvm.model.data

/**
 * Represents a character in the Rick and Morty
 * Note: Always check the API documentation to
 * see what fields are available and what you should expect:
 * https://rickandmortyapi.com/documentation
 */
data class Character (
    /** The name of the character. */
    val name: String,

    /** The species of the character. */
    val species: String,

    /** The URL of the character's image. */
    val image: String
)
