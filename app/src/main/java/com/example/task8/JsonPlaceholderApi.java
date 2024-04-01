package com.example.task8;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceholderApi {
    @GET("woof.json")
    Call<ImageData> getImageData();
}
