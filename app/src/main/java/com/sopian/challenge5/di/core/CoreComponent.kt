package com.sopian.challenge5.di.core

import android.content.Context
import com.sopian.challenge5.data.MovieRepository
import com.sopian.challenge5.data.UserRepository
import com.sopian.challenge5.storage.Storage
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class, StorageModule::class]
)
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    fun provideMovieRepository() : MovieRepository
    fun provideUserRepository() : UserRepository
    fun provideStorage() : Storage
}