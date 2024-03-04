package com.swent.mvvm.model.api

import com.swent.mvvm.model.data.Character

/**
 * Since the Rick and Morty API returns a list
 * of characters in the "results" field, we need
 * to create a data class to represent it.
 */
data class CharactersResponse(
    val results: List<Character>
)