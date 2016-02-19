package myapp.tae.ac.uk.lovemovie.api;

import java.util.List;

import myapp.tae.ac.uk.lovemovie.constants.Constants;
import myapp.tae.ac.uk.lovemovie.model.Movies;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import rx.Observable;

/**
 * Created by Karma on 11/02/16.
 */
public interface IMovies {
    @Headers("token: f90384c1-5a26-4a76-9f3b-fc0b37fe06f8")
    @GET(Constants.MOVIE_QUERY)
    Observable<Movies> getMovies();
}
