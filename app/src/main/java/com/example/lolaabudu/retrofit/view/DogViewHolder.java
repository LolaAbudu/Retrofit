package com.example.lolaabudu.retrofit.view;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lolaabudu.retrofit.R;
import com.example.lolaabudu.retrofit.model.Dogs;
import com.squareup.picasso.Picasso;

public class DogViewHolder extends RecyclerView.ViewHolder {

    private ImageView dogImageView;

    public DogViewHolder(@NonNull View itemView) {
        super(itemView);
        dogImageView = itemView.findViewById(R.id.dog_imageView);
    }

    public void onBind(Dogs dogs) {
        Picasso.get().load(dogs.getMessage()).into(dogImageView);
    }
}
