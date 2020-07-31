package com.example.perritos.model.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.perritos.model.FavDog;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {FavDog.class}, version = 1, exportSchema = false)
public abstract class FavsDogsDB extends RoomDatabase {
    public abstract FavsDogsDao dao();

    public static volatile FavsDogsDB INSTANCE;
    public static final int MAX_THREADS = 4;
    public static final ExecutorService dataExecutor =
            Executors.newFixedThreadPool(MAX_THREADS);

    public static FavsDogsDB getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (FavsDogsDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FavsDogsDB.class,
                            "favs_dogs").build();
                }
            }
        }

        return INSTANCE;
    }

}
