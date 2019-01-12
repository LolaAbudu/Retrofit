package com.example.lolaabudu.retrofit;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lolaabudu.retrofit.controller.DogAdapter;
import com.example.lolaabudu.retrofit.model.Dogs;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView dogsViewRV;

    private static final String BASE_URL_DOG_CEO = "https://dog.ceo";
    //private TextView dogTextView;
    private ImageView dogImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //dogTextView = findViewById(R.id.status_textView);
        dogImageView = findViewById(R.id.dog_imageView);
        dogsViewRV = findViewById(R.id.dogs_recyclerView);

        final List<Dogs> allDogsList = new ArrayList<>();



        final Retrofit retrofit = createRetrofit();
        DogApi api = retrofit.create(DogApi.class);
        Call<Dogs> dogCall = api.getDogs();
        dogCall.enqueue(new Callback<Dogs>() {
            @Override
            public void onResponse(Call<Dogs> call, Response<Dogs> response) {
                Dogs responseDog = response.body();
                Log.d("woohoo" ,"onResponse " + responseDog.getMessage());

                for(String s: responseDog.getMessage()){
                  allDogsList.add(new Dogs(s));
                }
                Picasso.get().load(responseDog.getMessage())
                        .into(dogImageView);
            }

            @Override
            public void onFailure(Call<Dogs> call, Throwable t) {

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
