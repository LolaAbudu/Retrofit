package com.example.lolaabudu.retrofit.model;

import android.media.Image;

import java.util.List;

public class Dogs {

    private final String status;
    private final List<String> message;


    public Dogs(String status, List<String> message){
        this.status=status;
        this.message=message;
    }

    public List<String> getMessage(){
        return message;
    }

    public String getStatus() {
        return status;
    }

}
