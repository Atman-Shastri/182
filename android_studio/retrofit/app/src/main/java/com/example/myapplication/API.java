package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    String BASE_URL = "https://api.github.com/";
    @GET("users")
    Call<List<MyClass>> getRecords();
}
