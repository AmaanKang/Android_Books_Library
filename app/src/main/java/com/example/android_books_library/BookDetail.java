package com.example.android_books_library;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        String bookUrl = getIntent().getStringExtra("bookUrl");
        TextView titleTextView = findViewById(R.id.book_title);
        TextView authorTextView = findViewById(R.id.author_name);
        ImageView coverImageView = findViewById(R.id.book_cover);

        titleTextView.setText(title);
        authorTextView.setText(author);
        Picasso.get().load(coverUrl).into(coverImageView);

        // Find the "Read the book" button in the layout
        Button readButton = findViewById(R.id.readButton);

        // Set an OnClickListener on the button to open the web view
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookDetail.this, WebViewActivity.class);
                intent.putExtra("url", bookUrl);
                startActivity(intent);
            }
        });
    }
}