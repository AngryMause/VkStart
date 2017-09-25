package ua.kek.dobriy_kot.startvk.dagger.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ua.kek.dobriy_kot.startvk.rest.RestClient;
import ua.kek.dobriy_kot.startvk.rest.api.WallApi;


@Module
public class RestClientModule {

    private RestClient restClient;

    public RestClientModule(){
        restClient=new RestClient();
    }
    @Singleton
    @Provides
    public RestClient provideRestClient (){
        return restClient;
    }

    @Singleton
    @Provides
    public WallApi provideWallApi(){
        return restClient.createServices(WallApi.class);
    }

}
