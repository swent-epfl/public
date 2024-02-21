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
        return try {
            fetchCharactersFromApi()
        } catch (e: IOException) { // Catching network errors
            ApiResponse.Error("Network error, could not fetch characters")
        } catch (e: Exception) {   // Catching unexpected errors
            ApiResponse.Error("Exception: ${e.message}")
        }
    }

    /**
     * Attempts to fetch characters from the API
     * Returns a success response with the data or an error if
     * no characters are found.
     */
    private suspend fun fetchCharactersFromApi(): ApiResponse<CharactersResponse> {
        val response = apiService.getCharacters()
        return if (response.isSuccessful) {

            /** Breakdown of this weird Kotlin block:
                response.body()? : If the response body is not null,
                then it will execute the let {}, otherwise it will
                return ApiResponse.Error("No characters found") */

            response.body()?.let {
                ApiResponse.Success(it)
            } ?: ApiResponse.Error("No characters found")

        } else {
            ApiResponse.Error("API error: ${response.code()}")
        }
    }
}
