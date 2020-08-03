package com.example.perritos.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.perritos.databinding.FragmentSecondBinding;
import com.example.perritos.view.adapters.DogsPhotoAdapter;
import com.example.perritos.viewmodel.ViewModelDogs;

import java.util.List;
import java.util.Objects;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private ViewModelDogs viewModelDogs;
    private RecyclerView recyclerView;
    private DogsPhotoAdapter dogsPhotoAdapter;
    private String breedSelected;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);

        viewModelDogs = new ViewModelProvider(requireActivity()).get(ViewModelDogs.class);

        recyclerView = binding.recyclerViewImg;
        dogsPhotoAdapter = new DogsPhotoAdapter();
        recyclerView.setAdapter(dogsPhotoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        breedSelected = viewModelDogs.getBreedSelected().getValue();

        viewModelDogs.getBreedSelected().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvBreedName.setText(breedSelected);
            }
        });

        viewModelDogs.getListUrlDogs(breedSelected).observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                dogsPhotoAdapter.updateListUrlImg(strings);
            }
        });



        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}