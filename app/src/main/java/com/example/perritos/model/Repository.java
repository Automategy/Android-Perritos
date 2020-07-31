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
    MutableLiveData<List<PojoDogs>> mvDogsUrl = new MutableLiveData<>();


    public Repository() {
        api = ApiServiceClient.getRetrofitInstance().create(ApiService.class);
    }


    public MutableLiveData<List<PojoDogs>> fetchDogsUrls() {

        Call<PojoDogs> call = api.getDogsURL("asdf");

        call.enqueue(new Callback<PojoDogs>() {
            @Override
            public void onResponse(Call<PojoDogs> call, Response<PojoDogs> response) {
                response.body().getMessage();
            }

            @Override
            public void onFailure(Call<PojoDogs> call, Throwable t) {

            }
        });
        return dogsUrl;
    }

    public LiveData<List<String>> fetchDogsBreeds() {
        LiveData<List<String>> dogsBreeds;

        return null;
    }
}
