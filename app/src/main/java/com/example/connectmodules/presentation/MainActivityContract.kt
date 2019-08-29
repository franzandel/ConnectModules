package com.example.testingactivity.presentation

/**
 * Created by Franz Andel on 2019-08-28.
 * Android Engineer
 */

class MainActivityContract {

    interface Router {
        fun goToTestActivityPage()
        fun goToDynamicFeatureActivityPage()
    }
}