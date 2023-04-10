package com.example.android_books_library;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OpenBooksAPI {
    @GET("books")
    Call<List<Book>> getBooks();
}

