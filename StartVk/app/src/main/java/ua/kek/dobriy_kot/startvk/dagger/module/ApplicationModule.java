package ua.kek.dobriy_kot.startvk.dagger.module;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private Application myApplication;

    public ApplicationModule(Application application){
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

    @Provides
    @Singleton
    Typeface provideGoogleFontTypeface(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "MaterialIcons-Regular.ttf");

    }

}
