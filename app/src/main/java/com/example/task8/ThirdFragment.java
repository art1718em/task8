package com.example.task8;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task8.databinding.FragmentThirdBinding;
import com.squareup.picasso.Picasso;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;


public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentThirdBinding.inflate(inflater, container, false);

        binding.btnDownloadImage.setOnClickListener(view -> {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://random.dog/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            JsonPlaceholderApi jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class);
            Call<ImageData> call = jsonPlaceholderApi.getImageData();
            call.enqueue(new Callback<ImageData>() {
                @Override
                public void onResponse(@NonNull Call<ImageData> call, @NonNull Response<ImageData> response) {
                    if (!response.isSuccessful()) {
                        return;
                    }

                    ImageData imageData = response.body();
                    String imageUrl = null;
                    if (imageData != null) {
                        imageUrl = imageData.getImageUrl();
                    }

                    Picasso.get().load(imageUrl).into(binding.image);
                }


                @Override
                public void onFailure(@NonNull Call<ImageData> call, @NonNull Throwable t) {
                }
            });

        });


        return binding.getRoot();
    }
}