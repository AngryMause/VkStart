package ua.kek.dobriy_kot.startvk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.kek.dobriy_kot.startvk.consts.ApiConstants;
import ua.kek.dobriy_kot.startvk.mvp.presenter.MainPresenter;
import ua.kek.dobriy_kot.startvk.mvp.view.MainView;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    @BindView(R.id.main_text_view)
    TextView mainText;
    @InjectPresenter
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter.checkAuth();
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
        mainText.setText(CurrentUser.getId());
    }
}
