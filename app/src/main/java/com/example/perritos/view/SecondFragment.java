package com.example.perritos.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.perritos.databinding.FragmentSecondBinding;
import com.example.perritos.viewmodel.ViewModelDogs;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private ViewModelDogs viewModelDogs;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);

        viewModelDogs = new ViewModelProvider(getActivity()).get(ViewModelDogs.class);

        viewModelDogs.getBreedSelected().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvBreedTitle.setText(s);
            }
        });




        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}