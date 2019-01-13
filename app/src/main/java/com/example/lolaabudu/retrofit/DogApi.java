package com.example.lolaabudu.retrofit;

import com.example.lolaabudu.retrofit.model.ResponseDog;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DogApi {
    String ENDPOINT_DOG = "api/breed/hound/images";

    @GET(ENDPOINT_DOG)
    Call<ResponseDog> getDogs();
}
