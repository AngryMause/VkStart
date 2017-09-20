package ua.kek.dobriy_kot.startvk.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dobriy_kot on 15.09.17.
 */

public class Full <T> {
    @SerializedName("response")
    @Expose
    public T response;
}
