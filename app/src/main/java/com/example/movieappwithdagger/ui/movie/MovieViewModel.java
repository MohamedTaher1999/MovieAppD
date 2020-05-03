package com.example.movieappwithdagger.ui.movie;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.movieappwithdagger.data.model.Moviedata;
import com.example.movieappwithdagger.data.remote.ApiConstans;
import com.example.movieappwithdagger.data.remote.ApiRepository;

import java.util.ArrayList;

import javax.inject.Inject;

public class MovieViewModel extends ViewModel {
    ApiRepository apiRepository;
    private ObservableField<Boolean> dataReady;
    private MutableLiveData<ArrayList<Moviedata>> movies;

    @Inject
    public MovieViewModel(ApiRepository apiRepository) {
        this.apiRepository=apiRepository;
        movies=new MutableLiveData<>();
        dataReady=new ObservableField<>(false);
        getMovies();
    }

    public ObservableField<Boolean> getDataReady() {
        return dataReady;
    }

    public void getMovies(){

        apiRepository.getListMovies().observeForever(new Observer<ArrayList<Moviedata>>() {
            @Override
            public void onChanged(ArrayList<Moviedata> moviedata) {
                movies.setValue(moviedata);
                System.out.println(String.valueOf(movies.getValue().size()));
                dataReady.set(true);


            }
        });
        apiRepository.getMovies(ApiConstans.nameCatogry,1);


    }
}
