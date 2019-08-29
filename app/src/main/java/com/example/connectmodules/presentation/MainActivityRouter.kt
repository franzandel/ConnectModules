package com.example.connectmodules.presentation

import android.content.Context
import android.content.Intent
import com.example.base.router.ScreenRouter
import com.example.testingactivity.presentation.MainActivityContract
import javax.inject.Inject

/**
 * Created by Franz Andel on 2019-08-28.
 * Android Engineer
 */

class MainActivityRouter @Inject constructor(private val mRouter: ScreenRouter,
                                             private val mContext: Context
): MainActivityContract.Router {
    override fun goToDynamicFeatureActivityPage() {
        mRouter.getScreenIntent(mContext, ScreenRouter.ActivityScreen.DynamicFeature.DynamicFeatureActivityScreen)?.run {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            mContext.startActivity(this)
        }
    }

    override fun goToTestActivityPage() {
        mRouter.getScreenIntent(mContext, ScreenRouter.ActivityScreen.Test.TestActivityScreen)?.run {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            mContext.startActivity(this)
        }
    }
}