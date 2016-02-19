package myapp.tae.ac.uk.lovemovie.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapp.tae.ac.uk.lovemovie.R;
import myapp.tae.ac.uk.lovemovie.adapter.MovieListAdapter;
import myapp.tae.ac.uk.lovemovie.constants.Constants;
import myapp.tae.ac.uk.lovemovie.model.Section;

/**
 * Created by Karma on 17/02/16.
 */
public class MovieList extends Fragment {
    @Bind(R.id.rcMovieList)
    RecyclerView rcMovieList;
    MovieListAdapter adapter;
    private List<Section> movieList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_list_fragment, container, false);
        ButterKnife.bind(this, view);
//        ArrayList<Section> movieList = getArguments().getParcelable(Constants.MOVIE_LIST_PARCEL);
        adapter = new MovieListAdapter(getActivity(), movieList);
        rcMovieList.setAdapter(adapter);
        rcMovieList.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    public void setMovieList(List<Section> movieList) {
        this.movieList = movieList;
    }
}
