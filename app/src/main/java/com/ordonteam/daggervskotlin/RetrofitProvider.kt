package com.ordonteam.daggervskotlin

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory

object RetrofitProvider {

    var testRetrofit: Lazy<Retrofit>? = null

    val retrofit by lazy {
        Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }

    fun get(): Retrofit {
        return testRetrofit?.value ?: retrofit
    }
}