package ua.kek.dobriy_kot.startvk.ui.fragmnet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.kek.dobriy_kot.startvk.MyApplication;
import ua.kek.dobriy_kot.startvk.R;
import ua.kek.dobriy_kot.startvk.common.utils.VkListHelper;
import ua.kek.dobriy_kot.startvk.model.WallItem;
import ua.kek.dobriy_kot.startvk.model.view.BaseViewModel;
import ua.kek.dobriy_kot.startvk.model.view.NewsItemBodyViewModel;
import ua.kek.dobriy_kot.startvk.model.view.NewsItemFooterViewModel;
import ua.kek.dobriy_kot.startvk.model.view.NewsItemHeaderViewModel;
import ua.kek.dobriy_kot.startvk.rest.api.WallApi;
import ua.kek.dobriy_kot.startvk.rest.model.reques.WallGetRequestModel;
import ua.kek.dobriy_kot.startvk.rest.model.response.WallGetResponse;

/**
 * Created by dobriy_kot on 15.09.17.
 */

public class NewsFeedFragment extends BaseFeedFragment {

    public static NewsFeedFragment newInstance(){

        return new NewsFeedFragment();
    }

    @Inject
    WallApi mWallApi;


    public NewsFeedFragment() {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mWallApi.get(new WallGetRequestModel(176175777).toMap()).enqueue(new Callback<WallGetResponse>() {
            @Override
            public void onResponse(Call<WallGetResponse> call, Response<WallGetResponse> response) {

                List<WallItem> wallItemList = VkListHelper.getWallList(response.body().response);
                List<BaseViewModel> list = new ArrayList<BaseViewModel>();
                for (WallItem wallItem : wallItemList) {
                    list.add(new NewsItemHeaderViewModel(wallItem));
                    list.add(new NewsItemBodyViewModel(wallItem));
                    list.add(new NewsItemFooterViewModel(wallItem));
                }
                mAdapter.addItems(list);
                Toast.makeText(getActivity(), "Likes: " + response.body().response.getItems().get(0).getLikes().getCount(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<WallGetResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.news_feed;
    }
}
