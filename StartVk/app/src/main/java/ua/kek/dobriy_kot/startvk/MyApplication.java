package ua.kek.dobriy_kot.startvk;

import android.app.Application;

import com.vk.sdk.VKSdk;

import ua.kek.dobriy_kot.startvk.dagger.componet.ApplicationComponent;
import ua.kek.dobriy_kot.startvk.dagger.componet.DaggerApplicationComponent;
import ua.kek.dobriy_kot.startvk.dagger.module.ApplicationModule;


public class MyApplication extends Application {

    private static ApplicationComponent applicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
        initComponent();
    }

    private void initComponent() {
        applicationComponent =
                DaggerApplicationComponent.builder()
                        .applicationModule(new ApplicationModule(this)).build();

    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
