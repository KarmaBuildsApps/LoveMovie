package myapp.tae.ac.uk.lovemovie.di.Components;


import javax.inject.Singleton;

import dagger.Component;
import myapp.tae.ac.uk.lovemovie.di.Modules.AppModule;
import myapp.tae.ac.uk.lovemovie.di.Modules.NetModule;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Karma on 11/02/16.
 */
@Singleton
@Component(modules = {NetModule.class, AppModule.class})
public interface NetComponent {
    Retrofit retrofit();

    OkHttpClient okClient();
}
