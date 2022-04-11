package com.geektech.filmapp;

import android.app.Application;

import com.geektech.filmapp.data.models.remote.FilmApi;
import com.geektech.filmapp.data.models.remote.RetrofitClient;

public class App extends Application {

    private RetrofitClient retrofitClient;
    public static FilmApi filmApi;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        filmApi = retrofitClient.createFilmApi();
    }
}
