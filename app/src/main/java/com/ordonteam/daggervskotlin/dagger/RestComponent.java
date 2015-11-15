package com.ordonteam.daggervskotlin.dagger;

import dagger.Component;
import retrofit.Retrofit;

@Component(modules = RestModule.class)
public interface RestComponent {

    Retrofit provideRetrofit();
}
