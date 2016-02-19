package myapp.tae.ac.uk.lovemovie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapp.tae.ac.uk.lovemovie.R;
import myapp.tae.ac.uk.lovemovie.api.OnMovieClickListener;
import myapp.tae.ac.uk.lovemovie.model.Image;
import myapp.tae.ac.uk.lovemovie.model.Item;
import myapp.tae.ac.uk.lovemovie.model.Section;

/**
 * Created by Karma on 17/02/16.
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private Context context;
    private List<Section> movies;

    public MovieListAdapter(Context context, List<Section> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_list_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Section movie = movies.get(position);
        if (movie.getItems().size() > 0) {
            String imageUri = movie.getItems().get(0).getImages().get(0).getUrl();
            String title = movie.getItems().get(0).getTitle();
            String column = movie.getItems().get(0).getLayout();
            Picasso.with(context).load(imageUri)
                    .resize(80, 80)
                    .centerCrop()
                    .into(holder.ivCoverImage);
        }
        holder.setMovieClickListener(new OnMovieClickListener() {
            @Override
            public void onMovieClicked(View view, int position) {
                Toast.makeText(context, "Clicked on movie " + position + 1, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.ivMovieCoverImage)
        ImageView ivCoverImage;
        @Bind(R.id.tvMovieName)
        TextView tvMovieName;
        OnMovieClickListener movieClickListener;
        RecyclerView.LayoutManager layoutManager;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setMovieClickListener(OnMovieClickListener movieClickListener) {
            this.movieClickListener = movieClickListener;
        }

        @Override
        public void onClick(View v) {
            movieClickListener.onMovieClicked(v, getLayoutPosition());
        }
    }
}
