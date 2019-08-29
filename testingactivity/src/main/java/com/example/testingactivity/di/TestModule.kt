package com.example.testingactivity.di

import android.content.Context
import com.example.base.di.scope.ActivityScope
import com.example.base.router.ScreenRouter
import com.example.testingactivity.presentation.TestRouter
import dagger.Module
import dagger.Provides

/**
 * Created by Franz Andel on 2019-08-28.
 * Android Engineer
 */

@Module
class TestModule {

    @Provides
    @ActivityScope
    fun provideTestRouter(
        mRouter: ScreenRouter,
        mContext: Context
    ): TestRouter {
        return TestRouter(mRouter, mContext)
    }
}