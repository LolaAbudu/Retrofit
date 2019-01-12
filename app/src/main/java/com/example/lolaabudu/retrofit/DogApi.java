package com.example.lolaabudu.retrofit;

import com.example.lolaabudu.retrofit.model.Dogs;
import com.example.lolaabudu.retrofit.model.RandomDog;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DogApi {
    String ENDPOINT_DOG = "api/breed/hound/imagesLinks to an external site";

    @GET(ENDPOINT_DOG)
    Call<RandomDog> getDogs();
}
