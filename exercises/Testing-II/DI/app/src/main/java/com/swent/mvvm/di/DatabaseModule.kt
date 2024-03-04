package com.swent.mvvm.di

import android.content.Context
import androidx.room.Room
import com.swent.mvvm.model.persistence.AppDatabase
import com.swent.mvvm.model.persistence.CharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    /** The goal of TODOs is to replicate the following functionality:
     *
         private val dao: CharacterDao by lazy {
            val db = Room.databaseBuilder(
            context.applicationContext,
                AppDatabase::class.java, "characters"
            ).build()
            db.characterDao()
         }
     *
     */

    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return TODO("Fill in the function")
    }

    fun provideCharacterDao(database: AppDatabase): CharacterDao {
        return TODO("Fill in the function")
    }
}
