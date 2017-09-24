package ua.kek.dobriy_kot.startvk.rest.api;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import ua.kek.dobriy_kot.startvk.rest.model.response.WallGetResponse;

/**
 * Created by dobriy_kot on 12.09.17.
 */
public interface WallApi   {
    @GET(ApiMethods.GET_WALL)
    Call<WallGetResponse> get(@QueryMap Map<String, String> map);
}
