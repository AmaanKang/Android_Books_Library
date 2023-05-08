package com.example.android_books_library;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FetchBooksTask fetchBooksTask = new FetchBooksTask(MainActivity.this, findViewById(R.id.list_view));
        fetchBooksTask.execute();
    }
}
