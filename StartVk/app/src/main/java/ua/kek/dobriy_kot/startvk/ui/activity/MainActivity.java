package ua.kek.dobriy_kot.startvk.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import javax.inject.Inject;

import ua.kek.dobriy_kot.startvk.MyApplication;
import ua.kek.dobriy_kot.startvk.R;
import ua.kek.dobriy_kot.startvk.consts.ApiConstants;
import ua.kek.dobriy_kot.startvk.mvp.presenter.MainPresenter;
import ua.kek.dobriy_kot.startvk.mvp.view.MainView;
import ua.kek.dobriy_kot.startvk.rest.api.WallApi;
import ua.kek.dobriy_kot.startvk.ui.fragmnet.NewsFeedFragment;

public class MainActivity extends BaseActivity implements MainView {


//   @BindView(R.id.mainTextView32)
    TextView mainText;


    @InjectPresenter
    MainPresenter mainPresenter;

    @Inject
    WallApi wallApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainPresenter.checkAuth();
        mainText= (TextView) findViewById(R.id.mainTextView32);
        MyApplication.getApplicationComponent().inject(this);


    }

    @Override
    protected int getMainContainLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                mainPresenter.checkAuth();
            }

            @Override
            public void onError(VKError error) {

            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void startSingIn() {
        VKSdk.login(this, ApiConstants.DEFAULT_LOGIN_SCOPE);

    }

    @Override
    public void signedIn() {
        setContent(NewsFeedFragment.newInstance());

    }
}
