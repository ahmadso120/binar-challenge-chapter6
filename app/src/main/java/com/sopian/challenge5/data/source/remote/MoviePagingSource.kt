package com.sopian.challenge5.data.source.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sopian.challenge5.data.source.remote.network.ApiService
import com.sopian.challenge5.domain.model.Movie
import com.sopian.challenge5.mapper.Mapper

class MoviePagingSource(private val apiService: ApiService) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val position = params.key ?: INITIAL_PAGE_INDEX
            val responseData = apiService.getPopularMovie(position).results

            LoadResult.Page(
                data = Mapper.mapResponsesToDomain(responseData),
                prevKey = if (position == INITIAL_PAGE_INDEX) null else position - 1,
                nextKey = if (responseData.isNullOrEmpty()) null else position + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val INITIAL_PAGE_INDEX = 1
    }
}