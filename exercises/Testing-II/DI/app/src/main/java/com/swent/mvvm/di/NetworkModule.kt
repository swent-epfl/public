package com.swent.mvvm.di

import com.swent.mvvm.model.api.RickAndMortyApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.Retrofit.*
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /** The goal of TODOs is to replicate the following functionality:
     *
        private val apiService: RickAndMortyApiService by lazy {
            Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RickAndMortyApiService::class.java)
        }
     *
     */

    fun provideRetrofit(): Retrofit = TODO("Fill in the function")

    fun provideRickAndMortyApiService(retrofit: Retrofit): RickAndMortyApiService =
        TODO("Fill in the function")

}
