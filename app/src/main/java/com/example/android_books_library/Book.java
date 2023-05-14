package com.example.android_books_library;

public class Book {
    private final String title;
    private final String author;
    private final String description;
    private final String coverUrl;
    private final String bookUrl;
    private final String bookText;

    public Book(String title, String author, String description, String coverUrl, String bookUrl, String bookText) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.coverUrl = coverUrl;
        this.bookUrl = bookUrl;
        this.bookText = bookText;
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

    public String getBookUrl() {
        return this.bookUrl;
    }

    public String getBookText() {
        return this.bookText;
    }
}

