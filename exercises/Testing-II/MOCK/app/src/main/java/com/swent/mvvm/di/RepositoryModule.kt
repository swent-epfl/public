package  com.swent.mvvm.di

import android.app.Application
import android.content.Context
import com.swent.mvvm.model.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object RepositoryModule{
//
//    @Singleton
//    @Provides
//    fun provideCharacterRepository(@ApplicationContext context: Context):CharacterRepository{
//        return CharacterRepository(context)
//    }
//}



