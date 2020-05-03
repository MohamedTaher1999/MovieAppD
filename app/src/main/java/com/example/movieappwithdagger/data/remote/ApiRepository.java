package com.example.movieappwithdagger.data.remote;

import androidx.lifecycle.MutableLiveData;

import com.example.movieappwithdagger.data.model.MovieDetails;
import com.example.movieappwithdagger.data.model.Moviedata;
import com.example.movieappwithdagger.data.model.ResultsMovies;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
@Singleton
public class ApiRepository {

    private WebServices apiService;
    private MutableLiveData<ArrayList<Moviedata>> movies;
    private MutableLiveData<MovieDetails> movieDetails;
    @Inject
    public ApiRepository(WebServices apiService){
        this.apiService = apiService;
        movies=new MutableLiveData<>();
        movieDetails=new MutableLiveData<>();
    }


    public MutableLiveData<MovieDetails> getMovieDetailsLiveData() {
        return movieDetails;
    }

    public MutableLiveData<ArrayList<Moviedata>> getListMovies() {
        return movies;
    }

    public void getMovies(String    category, int page) {
        Call<ResultsMovies> call = apiService.getMovies(category,ApiConstans.APIKEY,ApiConstans.LANGUAGE,page);
        call.enqueue(new Callback<ResultsMovies>() {
            @Override
            public void onResponse(Call<ResultsMovies> call, Response<ResultsMovies> response) {
                movies.setValue( response.body().getResults());
            }

            @Override
            public void onFailure(Call<ResultsMovies> call, Throwable t) {
                try {
                    throw new InterruptedException("Something went wrong!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


    }


}
