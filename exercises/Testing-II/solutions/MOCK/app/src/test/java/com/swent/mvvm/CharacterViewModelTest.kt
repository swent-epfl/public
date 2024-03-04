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

    val mContextMock = mockk<Context>(relaxed = true)
    val dao : CharacterDao = mockk()
    val apiservice: RickAndMortyApiService = mockk()
    private lateinit var viewModel: CharacterViewModel

//    private val repository: CharacterRepository = mockk()
    private val repository: CharacterRepository = CharacterRepository(
        mContextMock,
        dao,
        apiservice
    )

    private val observer : Observer<ApiResponse<CharactersResponse>> = mockk()

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined) // Use Unconfined dispatcher for testing
        coEvery { apiservice.getCharacters() } returns Response.success(
            CharactersResponse(
                listOf(Character("API Return Character", "Human", "Test Image"))
            )
        )
        coEvery { dao.insertAll(any()) } just Runs

        val mockResponse = ApiResponse.Success(
            CharactersResponse(
                listOf(Character("Test2 Character", "Human", "Test Image"))
            )
        )
//        coEvery { repository.getCharacters() } returns mockResponse
        every { observer.onChanged(any()) } just Runs

        viewModel = CharacterViewModel(repository)
        viewModel.characters.observeForever(observer)
    }

    @After
    fun tearDown() {
        viewModel.characters.removeObserver(observer)
        Dispatchers.resetMain()
    }


    @Test
    fun `when getAllCharacters called, then repository getCharacters is invoked`() = runTest {

        val mockResponse = ApiResponse.Success(
            CharactersResponse(
                listOf(Character("Test Character", "Human", "Test Image"))
            )
        )

        val mockResponse2 = ApiResponse.Success(
            CharactersResponse(
                listOf(Character("Test3 Character", "Human", "Test Image"))
            )
        )

        coEvery { repository.getCharacters() } returns mockResponse
        // Act
        viewModel.refresh() // This internally calls getAllCharacters

        // Assert
        // checking if onChanged was called with ApiResponse.Loading()
        verify(exactly = 1) { observer.onChanged(ApiResponse.Loading()) }

        // checking if onChanged was called with mockResponse
        verify(exactly = 1) { observer.onChanged(mockResponse2) }
    }

    @Test
    fun `when clear is called, then characters LiveData is empty`() = runTest {

        // Act
        viewModel.clear()

        // Assert
        verify { observer.onChanged(ApiResponse.Success(CharactersResponse(emptyList()))) }
    }

}
