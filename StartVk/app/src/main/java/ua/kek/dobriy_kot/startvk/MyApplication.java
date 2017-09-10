package ua.kek.dobriy_kot.startvk;

import android.app.Application;

import com.vk.sdk.VKSdk;

/**
 * Created by dobriy_kot on 10.09.17.
 */

public class MyApplication extends Application {



    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
    }
}
