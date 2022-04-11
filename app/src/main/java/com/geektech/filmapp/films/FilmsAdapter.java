package com.geektech.filmapp.films;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.filmapp.OnClick;
import com.geektech.filmapp.databinding.ItemFilmsBinding;
import com.geektech.filmapp.data.models.remote.Films;

import java.util.ArrayList;
import java.util.List;

public class FilmsAdapter  extends RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder> {
    private List<Films> films = new ArrayList<>();
    private OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    public void setFilms(List<Films> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmsBinding binding = ItemFilmsBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent,false
        );
        return new FilmsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsViewHolder holder, int position) {
holder.onBind(films.get(position));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    protected class FilmsViewHolder extends RecyclerView.ViewHolder{
private ItemFilmsBinding binding;

        public FilmsViewHolder(@NonNull ItemFilmsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Films film) {
            initListener(film);
            binding.tvDescription.setText(film.getDescription());
            binding.tvTitle.setText(film.getTitle());
            Log.e("TAG", "initListener: ");
        }

        private void initListener(Films film) {
            itemView.setOnClickListener(view -> onClick.OnClick(film));
        }
    }
}
