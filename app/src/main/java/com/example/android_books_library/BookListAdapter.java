package com.example.android_books_library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BookListAdapter extends BaseAdapter {

    private final Context context;
    private final List<Book> bookList;

    public BookListAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate the XML layout for a single item in the ListView
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_main, parent, false);
        }

        // Get references to the views in the layout
        ImageView imageView = convertView.findViewById(R.id.image_view);
        TextView titleTextView = convertView.findViewById(R.id.title_text_view);
        TextView authorTextView = convertView.findViewById(R.id.author_text_view);

        // Populate the views with data from the book at the current position
        Book book = bookList.get(position);
        titleTextView.setText(book.getTitle());
        authorTextView.setText(book.getAuthor());
        Picasso.get().load(book.getCoverUrl()).into(imageView); // You can use a library like Picasso to load the image asynchronously

        return convertView;
    }
}
