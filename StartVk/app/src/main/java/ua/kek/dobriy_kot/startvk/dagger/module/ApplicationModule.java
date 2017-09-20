package ua.kek.dobriy_kot.startvk.dagger.module;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dobriy_kot on 11.09.17.
 */
@Module
public class AplicationModule {
    private Application myApplication;

    public AplicationModule(Application application){
     this.myApplication=application;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return myApplication;
    }

    @Provides
    @Singleton
    LayoutInflater provideLayoutInflater(){
        return (LayoutInflater) myApplication.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

}
