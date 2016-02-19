package myapp.tae.ac.uk.lovemovie;

import android.app.Application;

import myapp.tae.ac.uk.lovemovie.constants.Constants;
import myapp.tae.ac.uk.lovemovie.di.Components.APIComponent;
import myapp.tae.ac.uk.lovemovie.di.Components.DaggerAPIComponent;
import myapp.tae.ac.uk.lovemovie.di.Components.DaggerNetComponent;
import myapp.tae.ac.uk.lovemovie.di.Components.NetComponent;
import myapp.tae.ac.uk.lovemovie.di.Modules.APIModule;
import myapp.tae.ac.uk.lovemovie.di.Modules.AppModule;
import myapp.tae.ac.uk.lovemovie.di.Modules.NetModule;

/**
 * Created by Karma on 11/02/16.
 */
public class MyApplication extends Application {
    private NetComponent mNetComponent;
    private APIComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .netModule(new NetModule(Constants.BASE_URL))
                .appModule(new AppModule(this))
                .build();
        mApiComponent = DaggerAPIComponent.builder()
                .aPIModule(new APIModule())
                .netComponent(mNetComponent)
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

    public APIComponent getAPIComponent() {
        return mApiComponent;
    }
}
