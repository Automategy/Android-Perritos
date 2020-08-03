package com.example.perritos.view.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.perritos.databinding.DogViewBinding;
import com.example.perritos.model.FavDog;

import java.util.List;

public class DogsPhotoAdapter extends RecyclerView.Adapter<DogsPhotoAdapter.VhDogsPhotoAdapter> {

    private List<String> listUrlsImg;
    private OnLongClick listener;

    public DogsPhotoAdapter(OnLongClick listener) {
        this.listener = listener;
    }

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
        Log.d("RV_LOAD_IMAGE", "onBindViewHolder: " + url);
        Glide.with(holder.iv.getContext()).load(url).override(400).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        if (listUrlsImg == null)
            return 0;

        return listUrlsImg.size();
    }

    public class VhDogsPhotoAdapter extends RecyclerView.ViewHolder {
        private ImageView iv;

        public VhDogsPhotoAdapter(@NonNull DogViewBinding binding) {
            super(binding.getRoot());
            iv = binding.ivDog;

            binding.cvDogs.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onLongClick(listUrlsImg.get(getAdapterPosition()));
                    return true;
                }
            });
        }
    }

    public interface OnLongClick {
        void onLongClick(String dogUrl);
    }
}
