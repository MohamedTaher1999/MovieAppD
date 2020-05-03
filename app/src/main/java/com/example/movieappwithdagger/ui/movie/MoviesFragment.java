package com.example.movieappwithdagger.ui.movie;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movieappwithdagger.R;
import com.example.movieappwithdagger.ViewModelProviderFactory;
import com.example.movieappwithdagger.data.remote.ApiConstans;
import com.example.movieappwithdagger.databinding.FragmentMoviesBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends DaggerFragment {
    private String movieType;
    private FragmentMoviesBinding binding;
    @Inject
    ViewModelProviderFactory providerFactory;

    private MovieViewModel viewModel;

    public MoviesFragment(String moviesType) {
        ApiConstans.nameCatogry=moviesType;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies,container,false);
        viewModel = ViewModelProviders.of(this, providerFactory).get(MovieViewModel.class);
        binding.setViewModel(viewModel);
        return  binding.getRoot();

    }

}
