package com.example.lolaabudu.retrofit.model;

import android.media.Image;

import java.util.List;

public class Dogs {

    private String message;


    public Dogs( String message){
        this.message=message;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message) {
        this.message=message;
    }

}
