package com.swent.mvvm.model.repository

import android.content.Context
import androidx.room.Room
import com.swent.mvvm.model.api.ApiResponse
import com.swent.mvvm.model.api.CharactersResponse
import com.swent.mvvm.model.api.RickAndMortyApiService
import com.swent.mvvm.model.data.Character
import com.swent.mvvm.model.persistence.AppDatabase
import com.swent.mvvm.model.persistence.CharacterDao
import com.swent.mvvm.model.persistence.CharacterEntity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

/**
 * A repository abstracts the origin of the data the app is using.
 * This makes it easier to change the data source in the future.
 *
 * Note that we pass context here to be able to initialize the DAO,
 * but this is not the best practice. Instead, setup the DAO with
 * dependency injection (eg: Hilt).
 */
class CharacterRepository(context: Context) {

    /** We initiate the 2 services here, but it could be also
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

    // Initializing the database (cache) service
    private val dao: CharacterDao by lazy {
        val db = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, "characters"
        ).build()
        db.characterDao()
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
            getCacheCharacters()
        } catch (e: Exception) {   // Catching unexpected errors
            ApiResponse.Error("Error fetching characters: ${e.message}")
        }
    }

    /**
     * Attempts to fetch characters from the API and cache them.
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
                setCacheCharacters(it.results)
                ApiResponse.Success(it)
            } ?: ApiResponse.Error("No characters found")

        } else {
            ApiResponse.Error("API error: ${response.code()}")
            // Or you could also try fetching characters from the cache instead.
        }
    }

    /**
     * Caches the list of character entities in the local database.
     */
    private suspend fun setCacheCharacters(characters: List<Character>) {
        val characterEntities = characters.map {
            CharacterEntity(it.name, it.species, it.image)
        }
        dao.insertAll(characterEntities)
    }

    /**
     * Fetches characters from the local cache.
     * Returns a success response with cached data or an error
     * if the cache was empty.
     */
    private suspend fun getCacheCharacters(): ApiResponse<CharactersResponse> {
        val cachedCharacters = dao.getAllCharacters()
        return if (cachedCharacters.isNotEmpty()) {
            ApiResponse.Success(CharactersResponse(cachedCharacters.map {
                Character(it.name, it.species, it.image)
            }))
        } else {
            ApiResponse.Error("No internet connection and no cached data available!")
        }
    }

}
