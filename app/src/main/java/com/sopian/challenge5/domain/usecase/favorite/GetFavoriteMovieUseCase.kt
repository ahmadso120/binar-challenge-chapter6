package com.sopian.challenge5.domain.usecase.favorite

import androidx.lifecycle.LiveData
import com.sopian.challenge5.data.MovieRepository
import com.sopian.challenge5.domain.model.Movie
import kotlinx.coroutines.flow.Flow

class GetFavoriteMovieUseCase(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): Flow<List<Movie>> {
        return movieRepository.getFavoriteMovies()
    }
}