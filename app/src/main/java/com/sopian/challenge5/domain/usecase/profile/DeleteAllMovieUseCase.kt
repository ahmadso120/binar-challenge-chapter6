package com.sopian.challenge5.domain.usecase.profile

import com.sopian.challenge5.data.MovieRepository

class DeleteAllMovieUseCase(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke() {
        return movieRepository.deleteAllMovie()
    }
}