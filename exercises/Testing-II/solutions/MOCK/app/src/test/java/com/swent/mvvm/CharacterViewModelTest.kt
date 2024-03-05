package com.swent.mvvm.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.swent.mvvm.model.api.ApiResponse
import com.swent.mvvm.model.api.CharactersResponse
import com.swent.mvvm.model.data.Character
import com.swent.mvvm.model.repository.CharacterRepository
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CharacterViewModelTest {

    // This rules allows LiveData to be tested synchronously, important in our case!
    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    // This rule automatically initializes late-init properties with @MockK, @RelaxedMockK, etc.
    @get:Rule
    val mockkRule = MockKRule(this)

    // Automatically initialize this mock and make it relaxed
    // (no need to stub all methods, mockk will try its best to return default values)
    @RelaxedMockK
    lateinit var repository: CharacterRepository

    private lateinit var viewModel: CharacterViewModel
    private val charactersResponseObserver: Observer<ApiResponse<CharactersResponse>> = mockk(relaxed = true)

    // Define a default set of dummy characters to be used across tests
    private val dummyCharacters = listOf(
        Character("Character 1", "Species 1", "Image URL 1"),
        Character("Character 2", "Species 2", "Image URL 2")
    )
    private val expectedApiResponse = ApiResponse.Success(CharactersResponse(dummyCharacters))


    // Running before each test
    @Before
    fun setUp() {
        // This is necessary to test LiveData
        Dispatchers.setMain(Dispatchers.Unconfined)

        // Prepare the repository to return the default set of dummy characters
        coEvery { repository.getCharacters() } returns expectedApiResponse

        viewModel = CharacterViewModel(repository)
        viewModel.characters.observeForever(charactersResponseObserver)
    }

    // Running after each test (good practice to clean up resources)
    @After
    fun tearDown() {
        viewModel.characters.removeObserver(charactersResponseObserver)
        Dispatchers.resetMain() // Reset the main dispatcher
    }

    @Test
    fun `when getAllCharacters called, then LiveData is updated`() = runTest {
        // Arrange is done in @Before

        // Act
        viewModel.refresh() // Simulate action that leads to LiveData update

        // Assert
        // Verify that LiveData was updated; with relaxed mock, specific responses are not necessary
        verify { charactersResponseObserver.onChanged(any()) }
    }

    @Test
    fun `when clear is called, then characters LiveData is empty`() = runTest {
        // Act
        viewModel.clear()

        // Assert
        // Verify that LiveData was updated to empty state
        verify { charactersResponseObserver.onChanged(any()) }
        // Verify if the LiveData was updated with an empty list of characters
        verify { charactersResponseObserver.onChanged(ApiResponse.Success(CharactersResponse(emptyList()))) }
    }

    @Test
    fun `when getCharacters is called, then LiveData contains specific characters`() = runTest {
        // Act
        viewModel.refresh()

        // Assert
        verify { charactersResponseObserver.onChanged(expectedApiResponse) }
    }
}

