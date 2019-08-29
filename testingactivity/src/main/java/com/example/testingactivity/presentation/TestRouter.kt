package com.example.testingactivity.presentation

import android.content.Context
import android.content.Intent
import com.example.base.router.ScreenRouter
import javax.inject.Inject

/**
 * Created by Franz Andel on 2019-08-28.
 * Android Engineer
 */

class TestRouter @Inject constructor(private val mRouter: ScreenRouter,
                                     private val mContext: Context
): TestContract.Router {
    override fun goToMainActivityPage() {
        mRouter.getScreenIntent(mContext, ScreenRouter.ActivityScreen.Main.MainActivityScreen)?.run {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            mContext.startActivity(this)
        }
    }
}