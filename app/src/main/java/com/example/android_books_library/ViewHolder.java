package com.example.android_books_library;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView titleTextView;
    public TextView authorTextView;
    public ImageView imageView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.title_text_view);
        authorTextView = itemView.findViewById(R.id.author_text_view);
        imageView = itemView.findViewById(R.id.image_view);
    }
}
