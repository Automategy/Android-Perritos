package com.example.perritos.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.perritos.databinding.DogViewBinding;

import java.util.List;

public class DogsPhotoAdapter extends RecyclerView.Adapter<DogsPhotoAdapter.VhDogsPhotoAdapter> {

    private List<String> listUrlsImg;

    public void updateListUrlImg(List<String> list) {
        listUrlsImg = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VhDogsPhotoAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DogViewBinding binding;

        binding = DogViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,
                false);

        return new VhDogsPhotoAdapter(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VhDogsPhotoAdapter holder, int position) {
        String url = listUrlsImg.get(position);


    }

    @Override
    public int getItemCount() {
        if (listUrlsImg == null)
            return 0;

        return listUrlsImg.size();
    }

    public class VhDogsPhotoAdapter extends RecyclerView.ViewHolder {

        public VhDogsPhotoAdapter(@NonNull DogViewBinding binding) {
            super(binding.getRoot());
        }
    }
}
