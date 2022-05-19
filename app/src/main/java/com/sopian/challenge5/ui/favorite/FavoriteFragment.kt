package com.sopian.challenge5.ui.favorite

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.sopian.challenge5.App
import com.sopian.challenge5.R
import com.sopian.challenge5.databinding.FragmentFavoriteBinding
import com.sopian.challenge5.ui.ViewModelFactory
import com.sopian.challenge5.utils.EventObserver
import javax.inject.Inject

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private val binding: FragmentFavoriteBinding by viewBinding()

    private lateinit var movieAdapter: FavoriteMovieAdapter

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: FavoriteViewModel by viewModels {
        factory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        setupAdapter()
        observeUi()
    }

    private fun setupAdapter() {
        movieAdapter = FavoriteMovieAdapter(viewModel::onMovieClicked)

        binding.apply {
            recyclerView.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = movieAdapter
            }
        }
    }

    private fun observeUi() {
        viewModel.favoriteMovies.observe(viewLifecycleOwner) {
            Log.d("FavoriteFragment", it.toString())
            movieAdapter.submitList(it)
        }

        viewModel.navigateToDetail.observe(viewLifecycleOwner, EventObserver{
            findNavController().navigate(
                FavoriteFragmentDirections.actionFavoriteFragmentToMovieDetailFragment(it)
            )
        })
    }
}