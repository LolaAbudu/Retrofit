package com.example.lolaabudu.retrofit;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lolaabudu.retrofit.controller.DogAdapter;
import com.example.lolaabudu.retrofit.model.Dogs;
import com.example.lolaabudu.retrofit.model.RandomDog;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String BASE_URL_DOG_CEO = "https://dog.ceo/";
    private RecyclerView dogsViewRV;

    final List<Dogs> allDogsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dogsViewRV = findViewById(R.id.dogs_recyclerView);

        Retrofit retrofit = createRetrofit();

        DogApi api = retrofit.create(DogApi.class);
        Call<RandomDog> dogCall = api.getDogs();

        dogCall.enqueue(new Callback<RandomDog>() {
            @Override
            public void onResponse(Call<RandomDog> call, Response<RandomDog> response) {
                RandomDog responseDog = response.body();

                Log.d("woohoo" ,"onResponse2: " + responseDog.getdogUrl());

                for(String s: responseDog.getdogUrl()){
                  allDogsList.add(new Dogs(s));
                  Log.d("woohoo", "onResponse" + allDogsList.size());
                }

                DogAdapter dogAdapter = new DogAdapter(allDogsList);

                GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3);

                dogsViewRV.setAdapter(dogAdapter);
                dogsViewRV.setLayoutManager(gridLayoutManager);
            }

            @Override
            public void onFailure(Call<RandomDog> call, Throwable t) {
                Log.d("nooway", "onFailure" + "Failed");
            }
        });
    }

    private Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL_DOG_CEO)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


}
