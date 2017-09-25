package ua.kek.dobriy_kot.startvk.ui.holder;


import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;
import ua.kek.dobriy_kot.startvk.MyApplication;
import ua.kek.dobriy_kot.startvk.R;
import ua.kek.dobriy_kot.startvk.model.view.NewsItemHeaderViewModel;

public class NewsItemHeaderHolder extends BaseViewHolder<NewsItemHeaderViewModel> {
//    @BindView(R.id.civ_profile_image)
    CircleImageView civProfileImage;

//    @BindView(R.id.tv_reposted_profile_name)
    TextView tvName;
//    @BindView(R.id.iv_reposted_icon)
    ImageView ivRepostedIcon;
//    @BindView(R.id.tv_reposted_profile_name)
    TextView tvRepostedProfileName;

    public NewsItemHeaderHolder(View itemView) {
        super(itemView);
        MyApplication.getApplicationComponent().inject(this);
        civProfileImage =  itemView.findViewById(R.id.civ_profile_image);
        tvName = itemView.findViewById(R.id.tv_profile_name);
        ivRepostedIcon = itemView.findViewById(R.id.iv_reposted_icon);
        tvRepostedProfileName = itemView.findViewById(R.id.tv_reposted_profile_name);

    }


    @Override
    public void bindViewHolder(NewsItemHeaderViewModel item) {
        Context context = itemView.getContext();

        Glide.with(context)
                .load(item.getProfilePhoto())
                .into(civProfileImage);
        tvName.setText(item.getProfileName());

        if (item.isRepost()) {
            ivRepostedIcon.setVisibility(View.VISIBLE);
            tvRepostedProfileName.setText(item.getRepostProfileName());
        } else {
            ivRepostedIcon.setVisibility(View.GONE);
            tvRepostedProfileName.setText(null);
        }

    }

    @Override
    public void unbindViewHolder() {
        civProfileImage.setImageBitmap(null);
        tvName.setText(null);
        tvRepostedProfileName.setText(null);

    }
}
