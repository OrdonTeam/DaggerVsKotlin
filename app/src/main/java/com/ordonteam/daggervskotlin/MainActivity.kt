package com.ordonteam.daggervskotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.EditText
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private val searchApi by lazy { SearchApi.get() }

    private val resultsView by lazy { findViewById(R.id.results) as RecyclerView }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultsView.layoutManager = LinearLayoutManager(this)
        resultsView.adapter = EmptyAdapter()
        (findViewById(R.id.query) as EditText).addOnTextChangedListener(onQueryChanged)
    }

    private val onQueryChanged = { query: String ->
        searchApi.call(query)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onSuccess, onError)
    }

    private val onSuccess = { searchResults: SearchResults ->
        if (searchResults.items.isEmpty()) {
            resultsView.adapter = EmptyAdapter()
        } else {
            resultsView.adapter = ResultsAdapter(searchResults)
        }
    }

    private val onError = { throwable: Throwable ->
        Log.e("throwable", throwable.toString())
        resultsView.adapter = EmptyAdapter()
    }
}
