package com.example.onlineexamination

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.onlineexamination.ui.login.LoginActivity
import org.junit.Before

import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginTest {

    @Before
    fun setup() {
        launch(LoginActivity::class.java)
    }


}