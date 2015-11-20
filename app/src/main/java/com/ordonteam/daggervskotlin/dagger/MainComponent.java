package com.ordonteam.daggervskotlin.dagger;

import com.ordonteam.daggervskotlin.MainActivity;

import dagger.Component;

@Component(dependencies = SearchComponent.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);

    class Inject {
        public static RestComponent restComponent = DaggerRestComponent.create();
        public static SearchComponent testSearchComponent;

        public static void inject(MainActivity mainActivity) {
            SearchComponent searchComponent = createSearchComponent();
            MainComponent mainComponent = DaggerMainComponent
                    .builder()
                    .searchComponent(searchComponent)
                    .build();
            mainComponent.inject(mainActivity);
        }

        private static SearchComponent createSearchComponent() {
            if (testSearchComponent != null) {
                return testSearchComponent;
            } else {
                return DaggerSearchComponent
                        .builder()
                        .restComponent(restComponent)
                        .build();
            }
        }
    }
}
