package com.geektech.filmapp.datails;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.geektech.filmapp.App;
import com.geektech.filmapp.R;
import com.geektech.filmapp.data.models.remote.Films;
import com.geektech.filmapp.databinding.FragmentFilmDetailBinding;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FilmDetailFragment extends Fragment {
    private FragmentFilmDetailBinding binding;
    private DetailsAdapter detailsAdapter;

    public FilmDetailFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailsAdapter = new DetailsAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFilmDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerFilmsDetail.setAdapter(detailsAdapter);
        String id = FilmDetailFragmentArgs.fromBundle(getArguments()).getArgumentDetail();
        App.filmApi.getFilmDetail(id).enqueue(new Callback<Films>() {
            @Override
            public void onResponse(Call<Films> call, Response<Films> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List responses = Collections.singletonList(response.body());
                    detailsAdapter.setList(responses);
                    Toast.makeText(requireActivity(), "Успешно", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(requireActivity(), "Провалено", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Films> call, Throwable t) {
                //add
            }
        });
    }


}