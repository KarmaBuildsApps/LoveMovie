package myapp.tae.ac.uk.lovemovie.di.Scopes;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Karma on 11/02/16.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface UserScopes {
}
