package com.example.android_books_library;

public class Book {
    private final String title;
    private final String author;
    private final String description;
    private final String coverUrl;

    public Book(String title, String author, String description, String coverUrl) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.coverUrl = coverUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getDescription() {
        return this.description;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }
}

