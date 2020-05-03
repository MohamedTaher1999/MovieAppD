package com.example.movieappwithdagger.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.movieappwithdagger.ui.movie.MovieViewModel;
import com.example.movieappwithdagger.di.ViewModelKey;
import com.example.movieappwithdagger.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel.class)
    public abstract ViewModel bindMainViewModel(MovieViewModel viewModel);

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelFactory);
}
