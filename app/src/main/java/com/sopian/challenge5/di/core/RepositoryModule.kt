package com.sopian.challenge5.di.core

import com.sopian.challenge5.data.MovieRepository
import com.sopian.challenge5.data.MovieRepositoryImpl
import com.sopian.challenge5.data.UserRepository
import com.sopian.challenge5.data.UserRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository

    @Binds
    abstract fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

}