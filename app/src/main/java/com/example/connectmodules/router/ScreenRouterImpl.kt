package com.example.connectmodules.router

import android.content.Context
import android.content.Intent
import com.example.base.router.ScreenRouter
import com.example.connectmodules.presentation.MainActivity
import com.example.testingactivity.presentation.TestActivity

/**
 * Created by Franz Andel on 2019-08-27.
 * Android Engineer
 */

class ScreenRouterImpl : ScreenRouter {
    override fun getScreenIntent(context: Context, screen: ScreenRouter.ActivityScreen): Intent? {
        val c: Class<*>? = when (screen) {
            ScreenRouter.ActivityScreen.Main.MainActivityScreen -> MainActivity::class.java
            ScreenRouter.ActivityScreen.Test.TestActivityScreen -> TestActivity::class.java
//            ScreenRouter.ActivityScreen.DynamicFeature.DynamicFeatureActivityScreen -> DynamicFeatureActivity::class.java
            else -> null
        }

        return if (c == null) null else Intent(context, c)
    }
}