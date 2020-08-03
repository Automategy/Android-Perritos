package com.example.perritos.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favs_dogs")
public class FavDog {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    private String breedName;
    private String dogUrl;

    public FavDog(String breedName, String dogUrl) {
        this.breedName = breedName;
        this.dogUrl = dogUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public String getDogUrl() {
        return dogUrl;
    }

    public void setDogUrl(String dogUrl) {
        this.dogUrl = dogUrl;
    }
}
