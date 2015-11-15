package com.ordonteam.daggervskotlin

import retrofit.http.GET
import retrofit.http.Query
import rx.Observable

interface SearchApi {

    @GET("search/users")
    fun call(@Query("q") query: String): Observable<SearchResults>
}
