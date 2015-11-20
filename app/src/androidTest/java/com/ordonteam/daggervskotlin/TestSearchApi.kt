package com.ordonteam.daggervskotlin

import rx.Observable

class TestSearchApi : SearchApi {
    override fun call(query: String): Observable<SearchResults> {
        return Observable.just(SearchResults(responseForQuery(query)))
    }

    private fun responseForQuery(query: String): List<SearchResult>? {
        if (query == "OrdonTeam") {
            return listOf(SearchResult("OrdonTeam", "", 5.5))
        } else {
            return emptyList()
        }
    }
}