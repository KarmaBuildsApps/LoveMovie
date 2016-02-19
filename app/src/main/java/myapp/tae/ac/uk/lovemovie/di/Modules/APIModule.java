package myapp.tae.ac.uk.lovemovie.di.Modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import myapp.tae.ac.uk.lovemovie.api.IMovies;
import myapp.tae.ac.uk.lovemovie.di.Scopes.UserScopes;
import retrofit2.Retrofit;

/**
 * Created by Karma on 11/02/16.
 */
@Module
public class APIModule {
    @UserScopes
    @Provides
    IMovies provdesMovies(Retrofit retrofit) {
        return retrofit.create(IMovies.class);
    }
}
