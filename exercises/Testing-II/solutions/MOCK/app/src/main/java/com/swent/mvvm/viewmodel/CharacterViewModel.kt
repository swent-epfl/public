package com.swent.mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swent.mvvm.model.api.ApiResponse
import com.swent.mvvm.model.api.CharactersResponse
import com.swent.mvvm.model.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val repository: CharacterRepository) : ViewModel() {
    // Create a repository instance, we pass the application context
//    private val repository: CharacterRepository by lazy { CharacterRepository(application) }

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

    /**
     * Function that reloads the characters from the API.
     */
    fun refresh() {
        getAllCharacters()
    }

    /**
     * Function that clears the response from the LiveData.
     */
    fun clear() {
        _characters.value = ApiResponse.Success(CharactersResponse(emptyList()))
    }
}