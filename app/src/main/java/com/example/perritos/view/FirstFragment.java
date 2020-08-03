package com.example.perritos.view;

import android.os.Binder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.perritos.R;
import com.example.perritos.databinding.FragmentFirstBinding;
import com.example.perritos.view.adapters.BreedListAdapter;
import com.example.perritos.viewmodel.ViewModelDogs;

import java.util.Arrays;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private RecyclerView recyclerView;
    private BreedListAdapter breedListAdapter;
    private ViewModelDogs viewModelDogs;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        viewModelDogs = new ViewModelProvider(this).get(ViewModelDogs.class);


        recyclerView = binding.recyclerView;
        breedListAdapter = new BreedListAdapter();
        recyclerView.setAdapter(breedListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        viewModelDogs.getListBreedDogs().observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                breedListAdapter.updateListBreed(strings);
            }
        });


        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}