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
    // TODO: Create a CharacterRepository instance named repository lazily

    // TODO: Create a mutable LiveData named _characters (private)

    // TODO: Create an immutable LiveData named characters that exposes _characters (public)

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
            // TODO: Call the repository to get the characters
        }
    }
}