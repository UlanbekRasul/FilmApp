package com.geektech.filmapp.films;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.filmapp.App;
import com.geektech.filmapp.OnClick;
import com.geektech.filmapp.R;
import com.geektech.filmapp.data.models.remote.Films;
import com.geektech.filmapp.databinding.FragmentFilmsBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsFragment extends Fragment implements OnClick {
    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;

    public FilmsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new FilmsAdapter();
        adapter.setOnClick(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmsBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recycler.setAdapter(adapter);
        App.filmApi.getFilms().enqueue(new Callback<List<Films>>() {
            @Override
            public void onResponse(Call<List<Films>> call, Response<List<Films>> response) {
                if (response.isSuccessful() && response.body() != null){
                    adapter.setFilms(response.body());
                }
                else Log.e("TAG", "onResponse: " + response.message());
            }

            @Override
            public void onFailure(Call<List<Films>> call, Throwable t) {
                Log.e("TAG", "onResponse: " + t.getLocalizedMessage());


            }
        });
    }


    @Override
    public void OnClick(Films film) {
        String id = film.getId();
        Navigation.findNavController(requireView()).navigate(FilmsFragmentDirections.
                actionFilmsFragmentToFilmDetailFragment(id));
    }
}