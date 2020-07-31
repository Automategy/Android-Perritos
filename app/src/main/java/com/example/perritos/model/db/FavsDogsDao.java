package com.example.perritos.model.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.perritos.model.FavDog;

import java.util.List;

@Dao
public interface FavsDogsDao  {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFavDog(FavDog dog);

    @Query("SELECT * FROM favs_dogs ORDER BY id")
    LiveData<List<FavDog>> getAllFavsDogs();

}
