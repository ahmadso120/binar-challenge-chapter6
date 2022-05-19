package com.sopian.challenge5.di.app

import com.sopian.challenge5.data.MovieRepository
import com.sopian.challenge5.data.UserRepository
import com.sopian.challenge5.domain.usecase.favorite.GetFavoriteMovieUseCase
import com.sopian.challenge5.domain.usecase.favorite.SetFavoriteMovieUseCase
import com.sopian.challenge5.domain.usecase.login.LoginUseCase
import com.sopian.challenge5.domain.usecase.login.SetIsAuthorizedUseCase
import com.sopian.challenge5.domain.usecase.movie.GetPopularMovieUseCase
import com.sopian.challenge5.domain.usecase.profile.DeleteAllMovieUseCase
import com.sopian.challenge5.domain.usecase.profile.DeleteAllUserUseCase
import com.sopian.challenge5.domain.usecase.profile.GetUserUseCase
import com.sopian.challenge5.domain.usecase.profile.UpdateUserUseCase
import com.sopian.challenge5.domain.usecase.register.RegisterUserUseCase
import dagger.Module
import dagger.Provides

@Module
object AppModule {

    @Provides
    fun provideGetFavoriteMovieUseCase(movieRepository: MovieRepository): GetFavoriteMovieUseCase {
        return GetFavoriteMovieUseCase(movieRepository)
    }

    @Provides
    fun provideSetFavoriteMovieUseCase(movieRepository: MovieRepository): SetFavoriteMovieUseCase {
        return SetFavoriteMovieUseCase(movieRepository)
    }

    @Provides
    fun provideLoginUseCase(userRepository: UserRepository): LoginUseCase {
        return LoginUseCase(userRepository)
    }

    @Provides
    fun provideSetIsAuthorizedUseCase(userRepository: UserRepository): SetIsAuthorizedUseCase {
        return SetIsAuthorizedUseCase(userRepository)
    }

    @Provides
    fun provideGetPopularMovieUseCase(movieRepository: MovieRepository): GetPopularMovieUseCase {
        return GetPopularMovieUseCase(movieRepository)
    }

    @Provides
    fun provideDeleteAllMovieUseCase(movieRepository: MovieRepository): DeleteAllMovieUseCase {
        return DeleteAllMovieUseCase(movieRepository)
    }

    @Provides
    fun provideDeleteAllUserUseCase(userRepository: UserRepository): DeleteAllUserUseCase {
        return DeleteAllUserUseCase(userRepository)
    }

    @Provides
    fun provideGetUserUseCase(userRepository: UserRepository): GetUserUseCase {
        return GetUserUseCase(userRepository)
    }

    @Provides
    fun provideUpdateUserUseCase(userRepository: UserRepository): UpdateUserUseCase {
        return UpdateUserUseCase(userRepository)
    }

    @Provides
    fun provideRegisterUserUseCase(userRepository: UserRepository): RegisterUserUseCase {
        return RegisterUserUseCase(userRepository)
    }


}