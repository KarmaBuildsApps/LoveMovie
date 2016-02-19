package myapp.tae.ac.uk.lovemovie.di.Components;

import javax.inject.Scope;

import dagger.Component;
import myapp.tae.ac.uk.lovemovie.MainActivity;
import myapp.tae.ac.uk.lovemovie.di.Modules.APIModule;
import myapp.tae.ac.uk.lovemovie.di.Modules.NetModule;
import myapp.tae.ac.uk.lovemovie.di.Scopes.UserScopes;


/**
 * Created by Karma on 11/02/16.
 */
@UserScopes
@Component(dependencies = NetComponent.class, modules = APIModule.class)
public interface APIComponent {
    void inject(MainActivity mainActivity);
}
