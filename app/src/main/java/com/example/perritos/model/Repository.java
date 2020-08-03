package com.example.perritos.model;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.perritos.model.apirest.ApiService;
import com.example.perritos.model.apirest.PojoBreeds;
import com.example.perritos.model.apirest.PojoDogs;
import com.example.perritos.model.db.FavsDogsDB;
import com.example.perritos.model.db.FavsDogsDao;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository{
    // retrofit
    private ApiService api;
    private List<String> dogsUrl;
    private MutableLiveData<List<String>> mvDogsUrl = new MutableLiveData<>();
    private MutableLiveData<List<String>> mvDogsBreeds = new MutableLiveData<>();
    //Room
    private FavsDogsDao dao;
    private LiveData<List<FavDog>> mvFavsDog;
    FavsDogsDB db;

    public Repository(Application application) {
        api = ApiService.ApiServiceClient.getRetrofitInstance().create(ApiService.class);

        db = FavsDogsDB.getDatabase(application);
        dao = db.dao();
        mvFavsDog = dao.getAllFavsDogs();

    }

    /*********************** LOCAL DATABASE *******************************************************/
    public LiveData<List<FavDog>> getFavsDogs() {
        mvFavsDog = dao.getAllFavsDogs();
        return mvFavsDog;
    }

    public void addFavsDogs(FavDog dog) {
        db.dataExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.insertFavDog(dog);
            }
        });
    }

    /********************** API REST **************************************************************/
    public MutableLiveData<List<String>> fetchDogsUrls(String breed) {
        Call<PojoDogs> call = api.getDogsURL(breed);

        call.enqueue(new Callback<PojoDogs>() {
            @Override
            public void onResponse(Call<PojoDogs> call, Response<PojoDogs> response) {
                Log.d("RETROFIT", "fetchDogsUrls: " + response.toString());
                if (response.code() == 200) {
                    Log.d("RETROFIT", "fetchDogsUrls: " + response.body().getMessage().toString());
                    mvDogsUrl.setValue(response.body().getMessage());
                } else {
                    mvDogsUrl.setValue(Collections.singletonList(""));
                }
            }

            @Override
            public void onFailure(Call<PojoDogs> call, Throwable t) {
                Log.d("RETROFIT", "fetchDogsUrls: " + t.toString());

                mvDogsUrl.setValue(Collections.singletonList(""));
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
                    Log.d("API_BREEDS", "onResponse: " + response.body().getMessage().toString());
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
        return mvDogsBreeds;
    }
}
