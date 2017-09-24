package ua.kek.dobriy_kot.startvk.dagger.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ua.kek.dobriy_kot.startvk.common.manager.MyFragmentManager;


@Module
public class FragmentManagerModule {
    private MyFragmentManager myFragmentManager;
    @Singleton
    @Provides
    public MyFragmentManager provideMyFragmentManager(){
        return new MyFragmentManager();
    }

}
