package com.example.perritos.model;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface IRepository {
    LiveData<List<String>> fetchDogsUrls();
    LiveData<List<String>> fetchDogsBreeds();
}
