package com.example.android_books_library;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class BookDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        String title = getIntent().getStringExtra("title");
        String author = getIntent().getStringExtra("author");
        String coverUrl = getIntent().getStringExtra("coverUrl");
        TextView titleTextView = findViewById(R.id.book_title);
        TextView authorTextView = findViewById(R.id.author_name);
        ImageView coverImageView = findViewById(R.id.book_cover);

        titleTextView.setText(title);
        authorTextView.setText(author);
        Picasso.get().load(coverUrl).into(coverImageView);

    }
}