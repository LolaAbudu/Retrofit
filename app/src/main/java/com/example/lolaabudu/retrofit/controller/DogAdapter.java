package com.example.lolaabudu.retrofit.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.lolaabudu.retrofit.R;
import com.example.lolaabudu.retrofit.model.Dogs;
import com.example.lolaabudu.retrofit.view.DogViewHolder;

import java.util.List;


public class DogAdapter extends RecyclerView.Adapter<DogViewHolder> {
    private List<Dogs> dogsList;

    public DogAdapter (List<Dogs> dogsList){
        this.dogsList=dogsList;
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View childview = LayoutInflater.from(parent.getContext()).inflate(R.layout.dog_itemview, parent, false);
        return new DogViewHolder(childview);
    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder dogViewHolder, int position) {
        Dogs dogs = dogsList.get(position);
        dogViewHolder.onBind(dogs);
    }

    @Override
    public int getItemCount() {
        return dogsList.size();
    }
}
