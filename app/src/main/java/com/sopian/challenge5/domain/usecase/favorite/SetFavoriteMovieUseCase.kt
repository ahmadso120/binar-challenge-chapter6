package com.sopian.challenge5.domain.usecase.favorite

import com.sopian.challenge5.data.MovieRepository
import com.sopian.challenge5.domain.model.Movie

class SetFavoriteMovieUseCase(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(movie: Movie, newStatus: Boolean) {
        return movieRepository.setFavoriteMovie(movie, newStatus)
    }
}