package ua.kek.dobriy_kot.startvk.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class RestClient  {
    private static final String BASE_VK_URL="https://api.vk.com/method/";
    private Retrofit retrofit;
    public RestClient (){
        retrofit=new Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_VK_URL).
                build();
    }
    public <S> S createServices(Class<S> services){
        return retrofit.create(services);
    }

}
