package com.ordonteam.daggervskotlin;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface SearchApi {

    @GET("search/users")
    Observable<SearchResults> call(@Query("q") String query);
}
