package com.ordonteam.daggervskotlin;

import com.ordonteam.daggervskotlin.dagger.SearchComponent;

import java.util.Collections;

import rx.Observable;

public class TestSearchComponent implements SearchComponent {

    @Override
    public SearchApi provideSearchApi() {
        return new SearchApi() {
            @Override
            public Observable<SearchResults> call(String query) {
                if (query.equals("OrdonTeam")) {
                    return ordonTeam;
                } else {
                    return emptyResults;
                }
            }
        };
    }

    private Observable<SearchResults> ordonTeam = Observable.just(
            new SearchResults(
                    Collections.singletonList(
                            new SearchResult("OrdonTeam", "https://avatars.githubusercontent.com/u/4918734?v=3", 46.791267)
                    )
            )
    );

    private Observable<SearchResults> emptyResults = Observable.just(
            new SearchResults(
                    Collections.<SearchResult>emptyList()
            )
    );
}
