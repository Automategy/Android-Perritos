package com.example.perritos.view;

import android.os.Binder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.perritos.databinding.FragmentFirstBinding;
import com.example.perritos.view.adapters.BreedListAdapter;

import java.util.Arrays;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private RecyclerView recyclerView;
    private BreedListAdapter breedListAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        recyclerView = binding.recyclerView;
        breedListAdapter = new BreedListAdapter();
        recyclerView.setAdapter(breedListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<String > razas = Arrays.asList("Hello", "World!", "How", "Are", "You", "Hello", "World!", "How", "Are", "You", "Hello", "World!", "How", "Are", "You","Hello", "World!", "How", "Are", "You");
        breedListAdapter.updateListBreed(razas);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}