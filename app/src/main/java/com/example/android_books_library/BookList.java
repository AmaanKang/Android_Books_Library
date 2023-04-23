package com.example.android_books_library;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class BookList {
    private final List<Book> books;

    public BookList(List<Book> books) {
        this.books = books;
    }

    public static BookList fromJson(String json) {
        Gson gson = new Gson();
        Type bookListType = new TypeToken<List<Book>>() {
        }.getType();
        List<Book> books = gson.fromJson(json, bookListType);
        return new BookList(books);
    }

    public List<Book> getBooks() {
        return this.books;
    }
}