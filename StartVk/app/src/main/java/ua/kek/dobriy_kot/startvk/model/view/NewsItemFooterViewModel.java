package ua.kek.dobriy_kot.startvk.model.view;


import android.view.View;

import ua.kek.dobriy_kot.startvk.entity.WallItem;
import ua.kek.dobriy_kot.startvk.model.view.counter.CommentCounterViewModel;
import ua.kek.dobriy_kot.startvk.model.view.counter.LikeCounterViewModel;
import ua.kek.dobriy_kot.startvk.model.view.counter.RepostCounterViewModel;
import ua.kek.dobriy_kot.startvk.ui.holder.BaseViewHolder;
import ua.kek.dobriy_kot.startvk.ui.holder.NewsItemFooterHolder;

public class NewsItemFooterViewModel extends BaseViewModel{

    private int mId;
    private int ownerId;
    private long mDateLong;

    private LikeCounterViewModel mLikes;
    private CommentCounterViewModel mComments;
    private RepostCounterViewModel mreposts;

    public NewsItemFooterViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.ownerId = wallItem.getOwnerId();
        this.mDateLong = wallItem.getDate();
        this.mLikes = new LikeCounterViewModel(wallItem.getLikes());
        this.mComments = new CommentCounterViewModel(wallItem.getComments());
        this.mreposts = new RepostCounterViewModel(wallItem.getReposts());
    }


    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemFooter;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemFooterHolder(view);
    }

    public long getDateLong() {
        return mDateLong;
    }

    public void setDateLong(long mDateLong) {
        this.mDateLong = mDateLong;
    }

    public int getId() {
        return mId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public LikeCounterViewModel getLikes() {
        return mLikes;
    }

    public CommentCounterViewModel getComments() {
        return mComments;
    }

    public RepostCounterViewModel getReposts() {
        return mreposts;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setLikes(LikeCounterViewModel mLikes) {
        this.mLikes = mLikes;
    }

    public void setComments(CommentCounterViewModel mComments) {
        this.mComments = mComments;
    }

    public void setMreposts(RepostCounterViewModel mreposts) {
        this.mreposts = mreposts;
    }
}
