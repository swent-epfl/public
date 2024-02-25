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
        // TODO: Implement a cache strategy to handle network errors
        return ApiResponse.Error("To be implemented")
    }
}
