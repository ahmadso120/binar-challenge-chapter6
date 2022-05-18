package com.sopian.challenge5.domain.usecase.favorite

import com.sopian.challenge5.data.MovieRepository
import com.sopian.challenge5.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): Flow<List<Movie>> {
        return movieRepository.getFavoriteMovies()
    }
}