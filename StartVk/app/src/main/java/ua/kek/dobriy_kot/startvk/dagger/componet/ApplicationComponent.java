package ua.kek.dobriy_kot.startvk.dagger.componet;

import dagger.Component;
import ua.kek.dobriy_kot.startvk.MainActivity;
import ua.kek.dobriy_kot.startvk.dagger.module.AplicationModule;
import ua.kek.dobriy_kot.startvk.dagger.module.FragmentManagerModule;
import ua.kek.dobriy_kot.startvk.dagger.module.RestClientModule;
import ua.kek.dobriy_kot.startvk.ui.activity.BaseActivity;
import ua.kek.dobriy_kot.startvk.ui.fragmnet.BaseFragmnet;

/**
 * Created by dobriy_kot on 11.09.17.
 */
@Component(modules = {AplicationModule.class, FragmentManagerModule.class, RestClientModule.class})
public class AplicationComponent {

//    void inject(BaseActivity);
//    void inject(MainActivity);
//
//    void inject(BaseFragmnet);

}
