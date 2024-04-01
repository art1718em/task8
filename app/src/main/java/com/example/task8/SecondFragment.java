package com.example.task8;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task8.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);

        binding.btnStartParallelProcesses.setOnClickListener(view -> {
            OneTimeWorkRequest work = new OneTimeWorkRequest.Builder(Work.class).build();
            OneTimeWorkRequest work1 = new OneTimeWorkRequest.Builder(Work1.class).build();
            List<OneTimeWorkRequest> list = new ArrayList<>();
            list.add(work);
            list.add(work1);
            WorkManager.getInstance(container.getContext()).enqueue(list);
        });

        binding.btnGoToDownloadImage.setOnClickListener(view -> Navigation.findNavController(binding.getRoot())
                .navigate(R.id.action_secondFragment_to_thirdFragment));

        return binding.getRoot();
    }
}