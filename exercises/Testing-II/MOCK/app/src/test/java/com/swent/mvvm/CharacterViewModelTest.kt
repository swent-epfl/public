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

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: CharacterViewModel

    // TODO: initialize mock context using mockk
    val mContextMock

    // TODO: initialize mock CharacterDao using mockk
    val dao : CharacterDao

    // TODO: initialize mock RickAndMortyApiService using mockk
    val apiservice: RickAndMortyApiService

    // TODO: you don't need to change repository, but try to make mock this as well, and see what happens.
    private val repository = CharacterRepository(
        mContextMock,
        dao,
        apiservice
    )

    private val observer : Observer<ApiResponse<CharactersResponse>> = mockk()

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined) // Use Unconfined dispatcher for testing

        // TODO: uncomment the following statements, and understand why the following three statements are needed.
//        coEvery { apiservice.getCharacters() } returns Response.success(
//            CharactersResponse(
//                listOf(Character("Test Character", "Human", "Test Image"))
//            )
//        )
//        coEvery { dao.insertAll(any()) } just Runs
//        every { observer.onChanged(any()) } just Runs

        viewModel = CharacterViewModel(repository)
        viewModel.characters.observeForever(observer)
    }

    @After
    fun tearDown() {
        viewModel.characters.removeObserver(observer)
        Dispatchers.resetMain()
    }

    @Test
    fun `when refresh, then repository getCharacters is invoked`() = runTest {

        val mockResponse = ApiResponse.Success(
            CharactersResponse(
                listOf(Character("Test Character", "Human", "Test Image"))
            )
        )

        val mockResponse2 = ApiResponse.Success(
            CharactersResponse(
                listOf(Character("Test2 Character", "Human", "Test Image"))
            )
        )

        // TODO: fill in the mock behavior, such that the repository.getCharacters would always return mockResponse
        coEvery { } returns

        // Act
        viewModel.refresh() // This internally calls getAllCharacters

        // Assertions

        // checking if onChanged was called with mockResponse
        // TODO: fix the failed check
        verify(exactly = 1) { observer.onChanged(mockResponse2) }

        //TODO: add another assertion, to checking if onChanged was called with ApiResponse.Loading()
        verify() { }
    }

    @Test
    fun `when clear is called, then characters LiveData is empty`() = runTest {

        // Act
        viewModel.clear()

        // Assert
        // TODO: fill in the assertion corresponding to `when clear is called, then characters LiveData is empty`
        verify { observer.onChanged() }
    }
}
