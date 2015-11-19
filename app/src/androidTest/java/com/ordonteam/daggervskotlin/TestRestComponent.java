package com.ordonteam.daggervskotlin;

import com.ordonteam.daggervskotlin.dagger.RestComponent;

import retrofit.Retrofit;

public class TestRestComponent implements RestComponent {

    @Override
    public Retrofit provideRetrofit() {
        throw new RuntimeException("Tests should not use Internet!");
    }
}
