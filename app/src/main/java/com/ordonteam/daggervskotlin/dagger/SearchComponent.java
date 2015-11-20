package com.ordonteam.daggervskotlin.dagger;

import com.ordonteam.daggervskotlin.SearchApi;

import dagger.Component;

@Component(
        modules = SearchModule.class,
        dependencies = RestComponent.class
)
public interface SearchComponent {

    SearchApi providerSearchApi();
}
