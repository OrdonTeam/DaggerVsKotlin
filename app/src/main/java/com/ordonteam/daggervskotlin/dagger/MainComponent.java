package com.ordonteam.daggervskotlin.dagger;

import com.ordonteam.daggervskotlin.MainActivity;

import dagger.Component;

@Component(dependencies = SearchComponent.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);

    class Injector {

        public static RestComponent restComponent = DaggerRestComponent.create();
        public static SearchComponent searchComponent;

        public static void inject(MainActivity mainActivity) {
            if (searchComponent == null) { // If wasn't set in tests, create it in regular way.
                searchComponent = DaggerSearchComponent.builder().restComponent(restComponent).build();
            }
            DaggerMainComponent.builder().searchComponent(searchComponent).build().inject(mainActivity);
        }
    }
}
