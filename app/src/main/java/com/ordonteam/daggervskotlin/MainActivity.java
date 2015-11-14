package com.ordonteam.daggervskotlin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import static com.ordonteam.daggervskotlin.Utils.addOnTextChangedListener;

public class MainActivity extends AppCompatActivity {

    private final SearchApi searchApi = new Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
            .create(SearchApi.class);

    private RecyclerView resultsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultsView = (RecyclerView) findViewById(R.id.results);
        resultsView.setLayoutManager(new LinearLayoutManager(this));
        resultsView.setAdapter(new EmptyAdapter());
        addOnTextChangedListener((EditText) findViewById(R.id.query), onQueryChanged);
    }

    private final Action1<String> onQueryChanged = new Action1<String>() {
        @Override
        public void call(String query) {
            searchApi.call(query)
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(onSuccess, onError);
        }
    };

    private final Action1<SearchResults> onSuccess = new Action1<SearchResults>() {
        @Override
        public void call(SearchResults searchResults) {
            if (searchResults.items.isEmpty()) {
                resultsView.setAdapter(new EmptyAdapter());
            } else {
                resultsView.setAdapter(new ResultsAdapter(searchResults));
            }
        }
    };

    private final Action1<Throwable> onError = new Action1<Throwable>() {
        @Override
        public void call(Throwable throwable) {
            Log.e("throwable", throwable.toString());
            resultsView.setAdapter(new EmptyAdapter());
        }
    };
}
