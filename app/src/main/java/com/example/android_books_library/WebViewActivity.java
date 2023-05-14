package com.example.android_books_library;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        // Retrieve the URL from the intent
        String url = getIntent().getStringExtra("url");
        // Find the web view in the layout
        WebView webView = findViewById(R.id.web_view);

        // Load the URL in the web view
        webView.loadUrl(url);
    }
}

