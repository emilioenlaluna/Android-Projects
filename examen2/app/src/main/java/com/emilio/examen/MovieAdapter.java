package com.emilio.examen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    Context context;
    List<MovieModel> list;

    public MovieAdapter(Context context, List<MovieModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_layout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.movieName.setText(list.get(position).getMovieName());
        holder.releaseYear.setText(list.get(position).getReleaseYear());
        holder.platform.setText(list.get(position).getPlatform());
        holder.movieImage.setImageResource(list.get(position).getMovieImage());

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyItemRemoved(position);
                Toast.makeText(context, "Película eliminada", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView movieImage;
        TextView movieName;
        TextView releaseYear;
        TextView platform;
        Button deleteButton;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            movieImage = itemView.findViewById(R.id.imageview_movie);
            movieName = itemView.findViewById(R.id.textview_movie_name);
            releaseYear = itemView.findViewById(R.id.textview_release_year);
            platform = itemView.findViewById(R.id.textview_platform);
            deleteButton = itemView.findViewById(R.id.button_delete_movie);
        }
    }
}
