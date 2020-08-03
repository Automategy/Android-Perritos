package com.example.perritos.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.perritos.model.FavDog;
import com.example.perritos.model.Repository;

import java.util.List;

public class ViewModelDogs extends AndroidViewModel {
    private Repository repository;
    private MutableLiveData<String> breedSelected;


    public ViewModelDogs(Application application) {
        super(application);
        breedSelected.setValue("");
        repository = new Repository(application);
    }

    public MutableLiveData<String> getBreedSelected() {
        return breedSelected;
    }

    public void setBreedSelected(String breedSelected) {
        this.breedSelected.setValue(breedSelected);
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
