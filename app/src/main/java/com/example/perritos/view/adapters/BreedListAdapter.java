package com.example.perritos.view.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.perritos.databinding.BreedsViewBinding;

import java.util.List;

public class BreedListAdapter extends RecyclerView.Adapter<BreedListAdapter.ViewHolderBreeds> {

    private List<String> breeds;

    public void updateListBreed(List<String> breeds) {
        this.breeds = breeds;
        Log.d("breeds", breeds.toString());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderBreeds onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BreedsViewBinding binding;
        binding = BreedsViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,
                false);
        return new ViewHolderBreeds(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderBreeds holder, int position) {
        String breed = breeds.get(position);
        holder.breedName.setText(breed);
    }

    @Override
    public int getItemCount() {
        if (breeds == null)
           return 0;

        return breeds.size();
    }



    public class ViewHolderBreeds extends RecyclerView.ViewHolder {
        private TextView breedName;

        public ViewHolderBreeds(@NonNull BreedsViewBinding binding) {
            super(binding.getRoot());
            breedName = binding.tvBreedName;
        }
    }
}
