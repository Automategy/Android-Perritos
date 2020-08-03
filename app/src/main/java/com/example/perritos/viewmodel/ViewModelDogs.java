package com.example.perritos.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.perritos.model.FavDog;
import com.example.perritos.model.Repository;

import java.util.List;

public class ViewModelDogs extends AndroidViewModel {
    private Repository repository;


    public ViewModelDogs(Application application) {
        super(application);
        repository = new Repository(application);
    }

    public LiveData<List<FavDog>> getListFavDogs() {
        return repository.getFavsDogs();
    }

    public LiveData<List<String>> getListBreedDogs() {
        return repository.fetchDogsBreeds();
    }

    public LiveData<List<String>> getListUrlDogs(String breed) {
        return repository.fetchDogsUrls(breed);
    }

    public void insertNewFavDog(FavDog dog) {
        repository.addFavsDogs(dog);
    }
}
