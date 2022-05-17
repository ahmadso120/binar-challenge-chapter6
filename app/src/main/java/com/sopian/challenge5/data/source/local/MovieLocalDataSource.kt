package com.sopian.challenge5.data.source.local

import com.sopian.challenge5.data.source.local.entity.MovieEntity
import com.sopian.challenge5.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

class MovieLocalDataSource private constructor(private val movieDao: MovieDao) {

    fun getAllMovie(): Flow<List<MovieEntity>> = movieDao.getAllMovie()

    fun setFavoriteMovie(movieEntity: MovieEntity, newState: Boolean) {
        if (newState) {
            movieEntity.isFavorite = newState
            movieDao.insertMovie(movieEntity)
        } else {
            movieDao.deleteMovie(movieEntity.id)
        }
    }

    suspend fun deleteAllMovie() = movieDao.deleteAll()

    companion object {
        @Volatile
        private var instance: MovieLocalDataSource? = null

        fun getInstance(movieDao: MovieDao): MovieLocalDataSource =
            instance ?: synchronized(this) {
                instance ?: MovieLocalDataSource(movieDao)
            }
    }
}