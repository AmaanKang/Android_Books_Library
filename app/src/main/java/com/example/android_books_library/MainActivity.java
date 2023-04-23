package com.example.android_books_library;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        FetchBooksTask fetchBooksTask = new FetchBooksTask(MainActivity.this, textView);
        fetchBooksTask.execute();
    }
}
