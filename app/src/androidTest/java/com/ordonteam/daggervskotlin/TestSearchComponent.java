package com.ordonteam.daggervskotlin;

import com.ordonteam.daggervskotlin.dagger.SearchComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rx.Observable;

public class TestSearchComponent implements SearchComponent {

    @Override
    public SearchApi providerSearchApi() {
        return new SearchApi() {
            @Override
            public Observable<SearchResults> call(String query) {
                return Observable.just(new SearchResults(resultsFor(query)));
            }
        };
    }

    private List<SearchResult> resultsFor(String query) {
        if (query.equals("OrdonTeam")) {
            return Collections.singletonList(new SearchResult("OrdonTeam", "", 5.5));
        } else {
            return new ArrayList<>();
        }
    }
}
