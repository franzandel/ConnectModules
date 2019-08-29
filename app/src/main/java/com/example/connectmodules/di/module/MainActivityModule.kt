package com.example.connectmodules.di.module

import android.content.Context
import com.example.base.di.scope.ActivityScope
import com.example.base.router.ScreenRouter
import com.example.connectmodules.presentation.MainActivityRouter
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import dagger.Module
import dagger.Provides

/**
 * Created by Franz Andel on 2019-08-28.
 * Android Engineer
 */

@Module
class MainActivityModule {

    @Provides
    @ActivityScope
    fun provideMainActivityRouter(
        mRouter: ScreenRouter,
        mContext: Context
    ): MainActivityRouter {
        return MainActivityRouter(mRouter, mContext)
    }

    @Provides
    @ActivityScope
    fun provideSplitInstallManager(
        mContext: Context
    ): SplitInstallManager {
        return SplitInstallManagerFactory.create(mContext)
    }
}