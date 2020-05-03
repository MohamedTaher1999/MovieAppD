package com.example.movieappwithdagger.di.module;

import com.example.movieappwithdagger.data.remote.ApiConstans;
import com.example.movieappwithdagger.data.remote.ApiRepository;
import com.example.movieappwithdagger.data.remote.WebServices;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    @Singleton
    static WebServices provideApiClient(Retrofit retrofit) {
        return retrofit.create(WebServices.class);
    }

    @Provides
    @Singleton
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(ApiConstans.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
