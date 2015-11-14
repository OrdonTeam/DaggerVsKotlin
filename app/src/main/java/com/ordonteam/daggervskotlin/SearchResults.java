package com.ordonteam.daggervskotlin;

import java.util.List;

public class SearchResults {
    public final List<SearchResult> items;

    public SearchResults(List<SearchResult> items) {
        this.items = items;
    }
}
