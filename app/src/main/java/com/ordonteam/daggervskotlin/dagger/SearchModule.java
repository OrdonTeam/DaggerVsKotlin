package com.ordonteam.daggervskotlin.dagger;

import com.ordonteam.daggervskotlin.SearchApi;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;

@Module
public class SearchModule {

    @Provides
    public SearchApi provideSearchApi(Retrofit retrofit) {
        return retrofit.create(SearchApi.class);
    }
}
