package com.geektech.filmapp.data.models.remote;

import com.google.gson.annotations.SerializedName;

public class Films {

    String id;
    String title;
    @SerializedName("original_title")
    String originalTitle;
    String description;
    String director;
    String producer;
    @SerializedName("release_date")
    String releaseDate;

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getDescription() {
        return description;
    }
}