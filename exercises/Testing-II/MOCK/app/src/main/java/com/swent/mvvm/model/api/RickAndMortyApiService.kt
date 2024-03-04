package com.swent.mvvm.model.api

import retrofit2.Response
import retrofit2.http.GET

/**
 * Defines the REST API calls for the
 * Rick and Morty API
 */
interface RickAndMortyApiService {
    @GET("character")
    suspend fun getCharacters(): Response<CharactersResponse>
}