package ua.kek.dobriy_kot.startvk.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;
import ua.kek.dobriy_kot.startvk.model.view.BaseViewModel;

/**
 * Created by dobriy_kot on 20.09.17.
 */

public abstract class BaseViewHolder <item extends BaseViewModel>extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public abstract void bindViewHolder(item item);

    public abstract void unbindViewHolder();

}
