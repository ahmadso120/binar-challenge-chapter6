package com.sopian.challenge5

import android.content.Context
import com.sopian.challenge5.data.*
import com.sopian.challenge5.data.source.local.MovieLocalDataSource
import com.sopian.challenge5.data.source.local.UserLocalDataSource
import com.sopian.challenge5.data.source.local.room.AppDatabase
import com.sopian.challenge5.data.source.remote.network.ApiConfig
import com.sopian.challenge5.domain.usecase.favorite.GetFavoriteMovieUseCase
import com.sopian.challenge5.domain.usecase.favorite.SetFavoriteMovieUseCase
import com.sopian.challenge5.domain.usecase.login.LoginUseCase
import com.sopian.challenge5.domain.usecase.profile.GetUserUseCase
import com.sopian.challenge5.domain.usecase.login.SetIsAuthorizedUseCase
import com.sopian.challenge5.domain.usecase.movie.GetPopularMovieUseCase
import com.sopian.challenge5.domain.usecase.profile.DeleteAllMovieUseCase
import com.sopian.challenge5.domain.usecase.profile.DeleteAllUserUseCase
import com.sopian.challenge5.domain.usecase.profile.UpdateUserUseCase
import com.sopian.challenge5.domain.usecase.register.RegisterUserUseCase
import com.sopian.challenge5.utils.AppExecutors

object Injection {

    private fun provideMovieRepository(context: Context): MovieRepository {
        val database = AppDatabase.getInstance(context)
        val apiService = ApiConfig.provideApiService()
        val localDataSource = MovieLocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()
        return MovieRepositoryImpl.getInstance(apiService, localDataSource, appExecutors)
    }

    fun provideGetPopularMovieUseCase(context: Context): GetPopularMovieUseCase {
        val repository = provideMovieRepository(context)
        return GetPopularMovieUseCase(repository)
    }

    private fun provideUserRepository(context: Context) : UserRepository {
        val database = AppDatabase.getInstance(context)
        val userLocalDataSource = UserLocalDataSource.getInstance(database.userDao())
        return UserRepositoryImpl.getInstance(userLocalDataSource)
    }

    fun provideRegisterUserUseCase(context: Context) : RegisterUserUseCase {
        val repository = provideUserRepository(context)
        return RegisterUserUseCase(repository)
    }

    fun provideDoLoginUserUseCase(context: Context) : LoginUseCase {
        val repository = provideUserRepository(context)
        return LoginUseCase(repository)
    }

    fun provideSetIsAuthorizedUseCase(context: Context) : SetIsAuthorizedUseCase {
        val repository = provideUserRepository(context)
        return SetIsAuthorizedUseCase(repository)
    }

    fun provideGetUserUseCase(context: Context) : GetUserUseCase {
        val repository = provideUserRepository(context)
        return GetUserUseCase(repository)
    }

    fun provideUpdateUserUseCase(context: Context) : UpdateUserUseCase {
        val repository = provideUserRepository(context)
        return UpdateUserUseCase(repository)
    }

    fun provideDeleteAllUserUseCase(context: Context) : DeleteAllUserUseCase {
        val repository = provideUserRepository(context)
        return DeleteAllUserUseCase(repository)
    }

    fun provideDeleteAllMovieUseCase(context: Context) : DeleteAllMovieUseCase {
        val repository = provideMovieRepository(context)
        return DeleteAllMovieUseCase(repository)
    }

    fun provideGetFavoriteMovieUseCase(context: Context) : GetFavoriteMovieUseCase {
        val repository = provideMovieRepository(context)
        return GetFavoriteMovieUseCase(repository)
    }

    fun provideSetFavoriteMovieUseCase(context: Context) : SetFavoriteMovieUseCase {
        val repository = provideMovieRepository(context)
        return SetFavoriteMovieUseCase(repository)
    }
}