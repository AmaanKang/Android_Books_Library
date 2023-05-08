package com.example.android_books_library;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FetchBooksTask extends AsyncTask<Void, Void, List<Book>> {
    private final Context context;
    private final ListView listView;

    public FetchBooksTask(Context context, ListView listView) {
        this.context = context;
        this.listView = listView;
    }

    @Override
    protected List<Book> doInBackground(Void... voids) {
        List<Book> books = new ArrayList<Book>();
        try {
            URL url = new URL("https://openlibrary.org/search.json?q=the+fellowship+of+the+rings+in+the+forest");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                Book book;

                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);
                // Extract the book information from the response
                JsonArray docs = jsonObject.getAsJsonArray("docs");
                for (JsonElement docElement : docs) {
                    JsonObject doc = docElement.getAsJsonObject();
                    String title = doc.get("title").getAsString();
                    JsonArray authorArray = doc.getAsJsonArray("author_name");
                    String author = (authorArray.size() > 0) ? authorArray.get(0).getAsString() : "Unknown";
                    String coverUrl = doc.has("cover_i") ? "https://covers.openlibrary.org/b/id/" + doc.get("cover_i").getAsString() + "-L.jpg" : "Unknown";

                    // Print out the book information
                    System.out.println("Title: " + title);
                    System.out.println("Author: " + author);
                    System.out.println("Cover URL: " + coverUrl);
                    book = new Book(title, author, "", coverUrl);
                    books.add(book);
                }
            } else {
                System.out.println("Error: " + responseCode);
            }
            return books;
        } catch (Exception e) {
            Log.e("*****", "Failed to fetch books", e);
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<Book> books) {
        if (books != null) {
            List<Book> bookList = books;
            BookListAdapter adapter = new BookListAdapter(this.context, bookList);
            listView.setAdapter(adapter);
        } else {
            Toast.makeText(context, "Failed to fetch books", Toast.LENGTH_SHORT).show();
        }
    }
}