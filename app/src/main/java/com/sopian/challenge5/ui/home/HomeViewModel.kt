package com.sopian.challenge5.ui.home

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.sopian.challenge5.domain.model.Movie
import com.sopian.challenge5.domain.usecase.movie.GetPopularMovieUseCase
import com.sopian.challenge5.utils.Event

class HomeViewModel(
    getPopularMovieUseCase: GetPopularMovieUseCase
) : ViewModel() {

    private val _menuItemSelectedLiveData = MutableLiveData<Event<Int>>()
    val menuItemSelectedLiveData: LiveData<Event<Int>> = _menuItemSelectedLiveData

    private val _navigateToDetail = MutableLiveData<Event<Movie>>()
    val navigateToDetail: LiveData<Event<Movie>>
        get() = _navigateToDetail

    fun onMovieClicked(movie: Movie) {
        _navigateToDetail.value = Event(movie)
    }

    fun onMenuItemSelected(actionId: Int) {
        _menuItemSelectedLiveData.postValue(Event(actionId))
    }

    private val _popularMovies = getPopularMovieUseCase().cachedIn(viewModelScope)
    val popularMovies: LiveData<PagingData<Movie>> get() = _popularMovies
}