package com.sopian.challenge5.domain.usecase.movie

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.sopian.challenge5.data.MovieRepository
import com.sopian.challenge5.domain.model.Movie

class GetPopularMovieUseCase(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): LiveData<PagingData<Movie>> {
        return movieRepository.getPopularMovies()
    }
}