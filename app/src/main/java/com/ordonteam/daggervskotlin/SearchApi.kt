package com.ordonteam.daggervskotlin

import retrofit.http.GET
import retrofit.http.Query
import rx.Observable

interface SearchApi {

    @GET("search/users")
    fun call(@Query("q") query: String): Observable<SearchResults>

    companion object {

        var testSearchApi: SearchApi? = null
        val searchApi by lazy { RetrofitProvider.get().create(SearchApi::class.java) }

        fun get(): SearchApi {
            return testSearchApi ?: searchApi
        }
    }
}
