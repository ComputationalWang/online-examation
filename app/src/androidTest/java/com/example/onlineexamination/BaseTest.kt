package com.example.onlineexamination

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId

/**
 * Contains test methods that will be used multiple times to reduce code duplication.
 */
open class BaseTest {

    /**
     * Test to ensure the app is in the correct state.
     * @param id Integer for the stringId
     * @param textActionResource Integer for the expected text resource.
     */
    fun testState(id: Int, textActionResource: Int) {
        Espresso.onView(withId(id))
            .check(matches(ViewMatchers.withText(textActionResource))
        )
    }
}