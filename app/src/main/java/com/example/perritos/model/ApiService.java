package com.example.perritos.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("breeds/list")
    Call<List<String>> getBreedsList();

    @GET("breed/{breed}/images")
    Call<List<String>> getDogsURL(@Path("breed") String breed);


}
