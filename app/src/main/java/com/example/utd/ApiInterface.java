package com.example.utd;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    String BASE_URL = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<MyModel.Root> getNews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("apiKey") String apiKey
    );
}
