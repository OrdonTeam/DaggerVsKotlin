package com.ordonteam.daggervskotlin

import rx.Observable

object TestSearchApi : SearchApi {

    override fun call(query: String): Observable<SearchResults> {
        if (query.equals("OrdonTeam")) {
            return ordonTeam
        } else {
            return emptyResults
        }
    }

    val ordonTeam = Observable.just(
            SearchResults(
                    listOf(
                            SearchResult("OrdonTeam", "https://avatars.githubusercontent.com/u/4918734?v=3", 46.791267)
                    )
            )
    )

    val emptyResults = Observable.just(
            SearchResults(
                    emptyList()
            )
    )
}