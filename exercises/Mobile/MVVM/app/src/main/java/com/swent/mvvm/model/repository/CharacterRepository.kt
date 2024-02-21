package com.swent.mvvm.model.repository

import com.swent.mvvm.model.api.ApiResponse
import com.swent.mvvm.model.api.CharactersResponse
import com.swent.mvvm.model.api.RickAndMortyApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

/**
 * A repository abstracts the origin of the data the app is using.
 * This makes it easier to change the data source in the future.
 */
class CharacterRepository() {

    /** We initiate the service here, but it could be also
     imported with dependency injection (eg: Hilt) which would
     help with testing without relying on a real API and
     properly mock it */

    // Initializing the API service
    private val apiService: RickAndMortyApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyApiService::class.java)
    }

    /**
     * Fetches the characters from the API module inside
     * of a ApiResponse wrapper. This way we can easily
     * handle Success, Error and Loading states.
     *
     * Notice the `suspend` keyword, it indicates that this
     * function can be paused and resumed at a later time,
     * and is essential for coroutines (async programming).
     */
    suspend fun getCharacters(): ApiResponse<CharactersResponse> {
        return TODO("Provide the return value")
    }
}
