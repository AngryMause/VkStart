package ua.kek.dobriy_kot.startvk.model;


import com.vk.sdk.api.model.Identifiable;

public interface Owner extends Identifiable{

    String getFullName();
    String getPhoto();
}
