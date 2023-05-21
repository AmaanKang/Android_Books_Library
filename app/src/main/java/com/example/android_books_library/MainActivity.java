package com.example.android_books_library;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ListView bookListView;
    private BookListAdapter bookListAdapter;
    private List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookListView = findViewById(R.id.list_view);
        bookList = new ArrayList<>();
        bookListAdapter = new BookListAdapter(this, bookList);
        bookListView.setAdapter(bookListAdapter);
        searchBooks("and");
        // Set up the SearchView
        SearchView searchView = findViewById(R.id.searchView);
        /**searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override public boolean onQueryTextSubmit(String query) {
        Log.d("----------------------",query);
        // Perform the book search
        searchBooks(query);
        return true;
        }

        @Override public boolean onQueryTextChange(String newText) {
        // You can perform incremental search here if desired
        searchBooks(newText);
        return true;
        }
        });*/
    }

    private void searchBooks(String query) {
        // Clear the previous book list
        bookList.clear();

        // Execute FetchBooksTask to fetch books based on the search query
        String apiUrl = "https://openlibrary.org/search.json?q=" + query;
        FetchBooksTask fetchBooksTask = new FetchBooksTask(this, bookList, bookListAdapter, bookListView);
        fetchBooksTask.execute(apiUrl);
    }
}
