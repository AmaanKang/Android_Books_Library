package com.example.android_books_library;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchBooksTask extends AsyncTask<Void, Void, Book> {

    private static final String TAG = FetchBooksTask.class.getSimpleName();

    private final TextView textView;
    private final Context context;

    public FetchBooksTask(Context context, TextView textView) {
        this.context = context;
        this.textView = textView;
    }

    @Override
    protected Book doInBackground(Void... voids) {
        try {
            URL url = new URL("https://openlibrary.org/works/OL45804W.json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            String response = stringBuilder.toString();
            response = "{'title':'Book 1','description':'Best'}";
            Log.d("***************************************", response);
            Gson gson = new Gson();
            Book bookList = gson.fromJson(response, Book.class);
            Log.d("***************************************", bookList.toString());
            return bookList;
        } catch (Exception e) {
            Log.e(TAG, "Failed to fetch books", e);
            return null;
        }
    }

    @Override
    protected void onPostExecute(Book books) {
        if (books != null) {
            StringBuilder stringBuilder = new StringBuilder();
            /**for (Book book : books) {
             stringBuilder.append(book.getTitle()).append("\n");
             }*/
            //textView.setText(stringBuilder.toString());
            textView.setText(books.getTitle());
        } else {
            Toast.makeText(context, "Failed to fetch books", Toast.LENGTH_SHORT).show();
        }
    }
}