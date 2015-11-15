package com.ordonteam.daggervskotlin.dagger;

import com.ordonteam.daggervskotlin.SearchApi;

import dagger.Component;

@Component(
        dependencies = RestComponent.class,
        modules = SearchModule.class
)
public interface SearchComponent {

    SearchApi provideSearchApi();
}
