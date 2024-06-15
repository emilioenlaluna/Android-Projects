package com.emilio.examen;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    List<MovieModel> movieList;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSet();
        loadMovies();

    }

    private void initSet() {
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void loadMovies() {
        movieList = new ArrayList<>();

        MovieModel movie1 = new MovieModel(R.drawable.movie1, "Pelicula 1", "2008", "Netflix");
        MovieModel movie2 = new MovieModel(R.drawable.movie2, "Pelicula 2", "1989", "Disney Plus");
        MovieModel movie3 = new MovieModel(R.drawable.movie3, "Pelicula 3", "2023", "blutv");
        MovieModel movie4 = new MovieModel(R.drawable.movie4, "Pelicula 4", "YouTube Premium", "2022");
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);
        movieList.add(movie4);

        adapter = new MovieAdapter(this, movieList);
        recyclerView.setAdapter(adapter);
    }
}
