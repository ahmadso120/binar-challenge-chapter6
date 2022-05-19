package com.sopian.challenge5.di.core

import com.sopian.challenge5.storage.SharedPreferencesStorage
import com.sopian.challenge5.storage.Storage
import dagger.Binds
import dagger.Module

@Module
abstract class StorageModule {

    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorage): Storage
}