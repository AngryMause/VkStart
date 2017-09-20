package ua.kek.dobriy_kot.startvk;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.kek.dobriy_kot.startvk.consts.ApiConstants;
import ua.kek.dobriy_kot.startvk.mvp.presenter.MainPresenter;
import ua.kek.dobriy_kot.startvk.mvp.view.MainView;
import ua.kek.dobriy_kot.startvk.rest.api.WallApi;
import ua.kek.dobriy_kot.startvk.rest.response.GetWallItemResponse;
import ua.kek.dobriy_kot.startvk.ui.activity.BaseActivity;

public class MainActivity extends BaseActivity implements MainView {
    @BindView(R.id.main_text_view)
    TextView mainText;

    @InjectPresenter
    MainPresenter mainPresenter;

    @Inject
    WallApi wallApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter.checkAuth();
        MyApplication.getAplicationComponent().inject(this);

        wallApi.get("176175777", CurrentUser.getAccessToken(), 1, "5.68").enqueue(new Callback<GetWallItemResponse>() {
            @Override
            public void onResponse(Call<GetWallItemResponse> call, Response<GetWallItemResponse> response) {
                mainText.setText(response.body().response.getCount());
            }

            @Override
            public void onFailure(Call<GetWallItemResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });


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
//        mainText.setText(CurrentUser.getId());

    }
}
