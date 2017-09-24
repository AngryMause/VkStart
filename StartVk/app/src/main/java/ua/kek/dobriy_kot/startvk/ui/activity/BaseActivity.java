package ua.kek.dobriy_kot.startvk.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.kek.dobriy_kot.startvk.MyApplication;
import ua.kek.dobriy_kot.startvk.R;
import ua.kek.dobriy_kot.startvk.common.manager.MyFragmentManager;
import ua.kek.dobriy_kot.startvk.ui.fragmnet.BaseFragment;

/**
 * Created by dobriy_kot on 11.09.17.
 */

public abstract class BaseActivity extends MvpAppCompatActivity {

    @BindView(R.id.main_container)
    FrameLayout mainContainer;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Inject
    MyFragmentManager myFragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout);
        ButterKnife.bind(this);
        getLayoutInflater().inflate(getMainContainLayout(), mainContainer);
        MyApplication.getApplicationComponent().inject(this);

    }

    public void setContent(BaseFragment fragment) {
        myFragmentManager.setFragment(this, fragment, R.id.main_container);
    }

    public void addContent(BaseFragment fragment) {
        myFragmentManager.addFragment(this, fragment, R.id.main_container);
    }

    public boolean removeCurrentFragment() {
        return myFragmentManager.removeCurrentFragment(this);
    }

    public boolean removeFragment(BaseFragment fragment) {
        return myFragmentManager.removeFragment(this, fragment);
    }


    @Override
    public void onBackPressed() {
        removeCurrentFragment();
    }


    public void fragmentOnScreen(BaseFragment baseFragment) {
        setToolbarTittle(baseFragment.createToolbarTitle(this));

    }

    private void setToolbarTittle(String tittle) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(tittle);
        }
    }

    @LayoutRes
    protected abstract int getMainContainLayout();
}
