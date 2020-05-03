package com.example.movieappwithdagger.ui.movie;

import com.example.movieappwithdagger.ui.movie.MoviesFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilder {

    @ContributesAndroidInjector
    abstract MoviesFragment contributePostsFragment();
}
