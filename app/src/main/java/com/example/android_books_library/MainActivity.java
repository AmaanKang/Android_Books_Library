package com.example.android_books_library;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private final List<Book> bookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(null);

        OpenBooksAPI service = ApiClient.getClient().create(OpenBooksAPI.class);
        Call<JsonObject> call = service.searchBooks("harry potter");

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    JsonObject result = response.body();
                    JsonArray docs = result.getAsJsonArray("docs");

                    for (int i = 0; i < docs.size(); i++) {
                        JsonObject doc = docs.get(i).getAsJsonObject();

                        String title = doc.get("title").getAsString();
                        String author = doc.get("author_name").getAsString();

                        String imageUrl = null;
                        if (doc.has("cover_i")) {
                            imageUrl = "https://covers.openlibrary.org/b/id/" + doc.get("cover_i").getAsString() + "-M.jpg";
                        }

                        Book book = new Book(title, author, imageUrl);
                        bookList.add(book);
                    }

                    BookAdapter bookAdapter = new BookAdapter(MainActivity.this, bookList);
                    recyclerView.setAdapter(bookAdapter);
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                BookAdapter bookAdapter = new BookAdapter(MainActivity.this, bookList);
                recyclerView.setAdapter(bookAdapter);
                Log.e("MainActivity", "Failed to fetch books", t);
            }
        });
    }
}
