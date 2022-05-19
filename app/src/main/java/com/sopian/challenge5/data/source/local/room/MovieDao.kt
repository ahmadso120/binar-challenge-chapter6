package com.sopian.challenge5.data.source.local.room

import androidx.room.*
import com.sopian.challenge5.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getAllMovie(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: MovieEntity)

    @Update
    fun updateFavoriteMovie(movieEntity: MovieEntity)

    @Query("DELETE FROM movie WHERE id = :id")
    fun deleteMovie(id: Long)

    @Query("DELETE FROM movie")
    suspend fun deleteAll()
}