package ua.kek.dobriy_kot.startvk.model.view.counter;




import ua.kek.dobriy_kot.startvk.model.Likes;

public class LikeCounterViewModel extends CounterViewModel{

    private Likes mLikes;

    public LikeCounterViewModel(Likes likes) {
        super(likes.getCount());

        this.mLikes = likes;

        if (mLikes.getUserLikes() == 1) {
            setAccentColor();
        }
    }



    public Likes getLikes() {
        return mLikes;
    }
}
