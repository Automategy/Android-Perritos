package com.example.perritos.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PojoBreeds {
    @SerializedName("message")
    @Expose
    public List<String> message = null;

    @SerializedName("status")
    @Expose
    public String status;
}
