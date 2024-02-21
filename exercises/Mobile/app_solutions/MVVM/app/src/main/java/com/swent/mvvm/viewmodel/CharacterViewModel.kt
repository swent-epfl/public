package com.swent.mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.swent.mvvm.model.api.ApiResponse
import com.swent.mvvm.model.api.CharactersResponse
import com.swent.mvvm.model.repository.CharacterRepository
import kotlinx.coroutines.launch

class CharacterViewModel(application: Application) : AndroidViewModel(application) {
    // Create a repository instance, we pass the application context
    private val repository: CharacterRepository by lazy { CharacterRepository() }

    private val _characters = MutableLiveData<ApiResponse<CharactersResponse>>()
    val characters: LiveData<ApiResponse<CharactersResponse>> = _characters

    init {
        /** We call the function to get the characters from the API
        as the ViewModel is created. */
        getAllCharacters()
    }

    private fun getAllCharacters() {

        /** This is a coroutine: it runs asynchronously without
        blocking the main thread, and setting the LiveData
        value when it's ready. */

        viewModelScope.launch {
            // Set the LiveData to Loading before the network request
            _characters.value = ApiResponse.Loading()

            // Make the network request and post the result to the LiveData
            _characters.value = repository.getCharacters()
        }
    }
}