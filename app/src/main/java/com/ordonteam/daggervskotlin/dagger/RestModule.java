package com.ordonteam.daggervskotlin.dagger;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

@Module
public class RestModule {

    @Provides
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
}
