package ua.kek.dobriy_kot.startvk.model.view.counter;



import ua.kek.dobriy_kot.startvk.model.Comments;

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
