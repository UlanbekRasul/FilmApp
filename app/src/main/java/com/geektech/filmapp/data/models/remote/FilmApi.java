package com.geektech.filmapp.data.models.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmApi {

    @GET("/films")
    Call<List<Films>>getFilms();

    @GET("/films/{id}")
    Call<Films> getFilmDetail(
            @Path("id") String id
    );
}
