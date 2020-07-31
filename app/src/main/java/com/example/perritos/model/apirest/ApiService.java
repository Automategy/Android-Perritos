package com.example.perritos.model.apirest;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("breeds/list")
    Call<PojoBreeds> getBreedsList();

    @GET("breed/{breed}/images")
    Call<PojoDogs> getDogsURL(@Path("breed") String breed);


    class ApiServiceClient {
        public static final String BASE_URL = "https://dog.ceo/api/";
        private static Retrofit retrofit = null;

        public static Retrofit getRetrofitInstance() {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder().
                        baseUrl(BASE_URL).
                        addConverterFactory(GsonConverterFactory.create()).
                        build();
            }

            return retrofit;
        }

    }
}
