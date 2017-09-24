package ua.kek.dobriy_kot.startvk.dagger.componet;

import javax.inject.Singleton;

import dagger.Component;
import ua.kek.dobriy_kot.startvk.dagger.module.ApplicationModule;
import ua.kek.dobriy_kot.startvk.dagger.module.FragmentManagerModule;
import ua.kek.dobriy_kot.startvk.dagger.module.RestClientModule;
import ua.kek.dobriy_kot.startvk.ui.activity.BaseActivity;
import ua.kek.dobriy_kot.startvk.ui.activity.MainActivity;
import ua.kek.dobriy_kot.startvk.ui.fragmnet.NewsFeedFragment;
import ua.kek.dobriy_kot.startvk.ui.holder.NewsItemBodyHolder;
import ua.kek.dobriy_kot.startvk.ui.holder.NewsItemFooterHolder;
import ua.kek.dobriy_kot.startvk.ui.holder.NewsItemHeaderHolder;


@Singleton
@Component(modules = {ApplicationModule.class, FragmentManagerModule.class, RestClientModule.class})
public interface ApplicationComponent {

    void inject(BaseActivity activity);
    void inject(MainActivity activity);

    void inject(NewsFeedFragment baseFragment);


    void inject(NewsItemBodyHolder bodyHolder);
    void inject(NewsItemFooterHolder footerHolder);

    void inject(NewsItemHeaderHolder headerHolder);
}
