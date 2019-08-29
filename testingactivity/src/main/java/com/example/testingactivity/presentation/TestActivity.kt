package com.example.testingactivity.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testingactivity.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_test.*
import javax.inject.Inject

/**
 * Created by Franz Andel on 2019-08-28.
 * Android Engineer
 */

class TestActivity : AppCompatActivity() {

    @Inject
    lateinit var testRouter: TestRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        btn_backToMainActivity.setOnClickListener {
            testRouter.goToMainActivityPage()
        }
    }
}