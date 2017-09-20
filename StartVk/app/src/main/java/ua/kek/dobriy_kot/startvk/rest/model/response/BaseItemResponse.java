package ua.kek.dobriy_kot.startvk.rest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dobriy_kot on 15.09.17.
 */

public class BaseItemResponse <T> {
    public Integer count;
    public List<T> item=new ArrayList<>();

    public Integer getCount() {
        return count;
    }

    public List<T> getItem() {
        return item;
    }
}
