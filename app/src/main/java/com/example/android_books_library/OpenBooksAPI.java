package com.example.android_books_library;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenBooksAPI {
    @GET("search.json")
    Call<JsonObject> searchBooks(@Query("q") String query);
}

