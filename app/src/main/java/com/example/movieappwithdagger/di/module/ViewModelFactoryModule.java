package com.example.movieappwithdagger.di.module;

import androidx.lifecycle.ViewModelProvider;

import com.example.movieappwithdagger.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);


}
