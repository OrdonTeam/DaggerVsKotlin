package com.ordonteam.daggervskotlin

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.test.ActivityInstrumentationTestCase2

class MainActivityTestCase : ActivityInstrumentationTestCase2<MainActivity>(MainActivity::class.java) {

    override fun setUp() {
        super.setUp()
        RetrofitProvider.overrided = lazy { throw RuntimeException("Tests should not use Internet!") }
        SearchApi.overrided = TestSearchApi
        getActivity()
    }

    fun testShouldDisplayNoResultsOnStart() {
        Thread.sleep(5000)
        Espresso.onView(ViewMatchers.withText(R.string.no_results_or_error)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun testShouldDisplayOrdonTeamProfileAfterFillingQuery() {
        Espresso.onView(ViewMatchers.withId(R.id.query)).perform(ViewActions.typeText("OrdonTeam"))

        Thread.sleep(5000)
        Espresso.onView(ViewMatchers.withId(R.id.login)).check(ViewAssertions.matches(ViewMatchers.withText("OrdonTeam")))
        Espresso.onView(ViewMatchers.withText(R.string.no_results_or_error)).check(ViewAssertions.doesNotExist())
    }
}
