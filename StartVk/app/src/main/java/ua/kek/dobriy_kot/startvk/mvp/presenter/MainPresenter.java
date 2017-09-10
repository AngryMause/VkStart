package ua.kek.dobriy_kot.startvk.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;


import ua.kek.dobriy_kot.startvk.CurrentUser;
import ua.kek.dobriy_kot.startvk.mvp.view.MainView;

/**
 * Created by dobriy_kot on 10.09.17.
 */
@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    public void checkAuth(){
        if (!CurrentUser.isAuthorized()){
            getViewState().startSingIn();
        }else {
            getViewState().signedIn();
        }
    }
}
