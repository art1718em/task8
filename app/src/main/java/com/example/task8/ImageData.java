package com.example.task8;

import com.google.gson.annotations.SerializedName;

public class ImageData {
    @SerializedName("fileSizeBytes")
    private int fileSizeBytes;
    @SerializedName("url")
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }


}
