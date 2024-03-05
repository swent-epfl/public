package com.swent.mvvm.viewmodel

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.swent.mvvm.model.api.ApiResponse
import com.swent.mvvm.model.api.CharactersResponse
import com.swent.mvvm.model.api.RickAndMortyApiService
import com.swent.mvvm.model.data.Character
import com.swent.mvvm.model.persistence.CharacterDao
import com.swent.mvvm.model.repository.CharacterRepository
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit4.MockKRule
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import retrofit2.Response
@ExperimentalCoroutinesApi
class CharacterViewModelTest {

    // This rules allows LiveData to be tested synchronously, important in our case!
    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    // This rule automatically initializes late-init properties with @MockK, @RelaxedMockK, etc.
    @get:Rule
    val mockkRule = MockKRule(this)

    // TODO: Initialize the ViewModel with the repository.
    // Hint: Use CharacterViewModel(repository)

    // Automatically initialize this mock and make it relaxed
    // (no need to stub all methods, mockk will try its best to return default values)
    @RelaxedMockK
    lateinit var repository: CharacterRepository

    // TODO: Mock an Observer for ApiResponse<CharactersResponse>.
    // Hint: Use mockk<Observer<ApiResponse<CharactersResponse>>>(relaxed = true)

    // TODO: Define a list of dummy characters for testing.

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)

        // TODO: Fill in the setup method (check README.md for instructions).
    }

    @After
    fun tearDown() {
        // TODO: Remove the observer from the ViewModel's LiveData.

        // Reset the main coroutine dispatcher to the original dispatcher.
        Dispatchers.resetMain()
    }

    @Test
    fun `when getAllCharacters called, then LiveData is updated`() {
        // TODO: Call the refresh method on the ViewModel.

        // TODO: Verify that the observer's onChanged was called with any value.
    }

    @Test
    fun `when clear is called, then characters LiveData is empty`() {
        // TODO: Call the clear method on the ViewModel.

        // TODO: Verify that the observer's onChanged was called with an empty list.
    }

    @Test
    fun `when getCharacters is called, then LiveData contains specific characters`() {
        // TODO: Refresh characters and verify that LiveData was updated with specific characters.
    }
}
