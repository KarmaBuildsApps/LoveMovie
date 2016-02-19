package myapp.tae.ac.uk.lovemovie;

import android.app.ProgressDialog;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

import myapp.tae.ac.uk.lovemovie.constants.Constants;
import myapp.tae.ac.uk.lovemovie.model.Movies;
import myapp.tae.ac.uk.lovemovie.model.Section;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

import javax.inject.Inject;

import myapp.tae.ac.uk.lovemovie.api.IMovies;
import myapp.tae.ac.uk.lovemovie.fragments.MovieList;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    @Inject
    IMovies mIMovies;
    private CompositeSubscription subscriptions = new CompositeSubscription();
    private FragmentManager mFManager;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication) getApplication()).getAPIComponent().inject(this);
        mFManager = getSupportFragmentManager();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading ...");
        progressDialog.show();
        getMovieList();
    }

    private void getMovieList() {
        if (!progressDialog.isShowing())
            progressDialog.show();
        subscriptions.add(mIMovies.getMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Movies>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        disableProgressDialog();
                        Log.i(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Movies movies) {
                        disableProgressDialog();
                        Log.i(TAG, "call: Success");
                        List<Section> movieList = movies.getSections();
//                        Bundle bundle = new Bundle();
//                        bundle.putParcelableArrayList(Constants.MOVIE_LIST_PARCEL, new ArrayList<Section>(movieList));
                        MovieList movieFragment = new MovieList();
                        movieFragment.setMovieList(movieList);
//                        movieFragment.setArguments(bundle);
                        mFManager.beginTransaction().add(R.id.frlMovieList, movieFragment).commit();
                    }
                }));
    }

    public void disableProgressDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }


}
