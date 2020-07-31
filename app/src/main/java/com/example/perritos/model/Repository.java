package com.example.perritos.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Repository{
    private ApiService api;
    List<String> dogsUrl;
    MutableLiveData<List<String>> mvDogsUrl = new MutableLiveData<>();
    MutableLiveData<List<String>> mvDogsBreeds = new MutableLiveData<>();


    public Repository() {
        api = ApiServiceClient.getRetrofitInstance().create(ApiService.class);
    }


    public MutableLiveData<List<String>> fetchDogsUrls() {
        Call<PojoDogs> call = api.getDogsURL("asdf");

        call.enqueue(new Callback<PojoDogs>() {
            @Override
            public void onResponse(Call<PojoDogs> call, Response<PojoDogs> response) {
                if (response.code() == 200) {
                    mvDogsUrl.setValue(response.body().getMessage());
                } else {
                    mvDogsUrl.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<PojoDogs> call, Throwable t) {
                mvDogsUrl.setValue(null);
            }
        });

        return mvDogsUrl;
    }


    public LiveData<List<String>> fetchDogsBreeds() {
        Call<PojoBreeds> call = api.getBreedsList();

        call.enqueue(new Callback<PojoBreeds>() {
            @Override
            public void onResponse(Call<PojoBreeds> call, Response<PojoBreeds> response) {
                if (response.code() == 200) {
                    mvDogsBreeds.setValue(response.body().getMessage());
                } else {
                    mvDogsBreeds.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<PojoBreeds> call, Throwable t) {
                mvDogsBreeds.setValue(null);
            }
        });
        return mvDogsUrl;
    }
}
