package com.ordonteam.daggervskotlin;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;

public class MainActivityTestCase extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTestCase() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testShouldDisplayNoResultsOnStart() throws Exception {
        Thread.sleep(5000);
        Espresso.onView(ViewMatchers.withText(R.string.no_results_or_error)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    public void testShouldDisplayOrdonTeamProfileAfterFillingQuery() throws Exception {
        Espresso.onView(ViewMatchers.withId(R.id.query)).perform(ViewActions.typeText("OrdonTeam"));

        Thread.sleep(5000);
        Espresso.onView(ViewMatchers.withId(R.id.login)).check(ViewAssertions.matches(ViewMatchers.withText("OrdonTeam")));
        Espresso.onView(ViewMatchers.withText(R.string.no_results_or_error)).check(ViewAssertions.doesNotExist());
    }
}
