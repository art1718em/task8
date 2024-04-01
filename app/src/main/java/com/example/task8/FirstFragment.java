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

import com.example.task8.databinding.FragmentFirstBinding;




public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        binding.btnStartConsecutiveProcesses.setOnClickListener(view -> {
            OneTimeWorkRequest work = new OneTimeWorkRequest.Builder(Work.class).build();
            OneTimeWorkRequest work1 = new OneTimeWorkRequest.Builder(Work1.class).build();
            OneTimeWorkRequest work2 = new OneTimeWorkRequest.Builder(Work2.class).build();
            WorkManager.getInstance(container.getContext()).beginWith(work).then(work1).then(work2).enqueue();

        });


        binding.btnGoToParallelProcesses.setOnClickListener(view -> Navigation.findNavController(binding.getRoot())
                .navigate(R.id.action_firstFragment_to_secondFragment));


        return binding.getRoot();
    }
}