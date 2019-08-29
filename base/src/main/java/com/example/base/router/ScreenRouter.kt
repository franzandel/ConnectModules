package com.example.base.router

import android.content.Context
import android.content.Intent

/**
 * Created by Franz Andel on 2019-08-27.
 * Android Engineer
 */

interface ScreenRouter {

    sealed class ActivityScreen {
        class Main {
            object MainActivityScreen : ScreenRouter.ActivityScreen()
        }

        class Test {
            object TestActivityScreen : ScreenRouter.ActivityScreen()
        }

        class DynamicFeature {
            object DynamicFeatureActivityScreen : ScreenRouter.ActivityScreen()
        }
    }

    fun getScreenIntent(context: Context, screen: ActivityScreen) : Intent?
}