package ua.kek.dobriy_kot.startvk.model.view.counter;



import ua.kek.dobriy_kot.startvk.entity.Comments;

public class CommentCounterViewModel extends CounterViewModel{

    private Comments mComments;

    public CommentCounterViewModel(Comments comments) {
        super(comments.getCount());

        this.mComments = comments;
    }



    public Comments getComments() {
        return mComments;
    }
}
