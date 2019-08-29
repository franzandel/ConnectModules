package com.example.dynamicfeature_test

import android.content.Context
import com.example.base.di.scope.ActivityScope
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import dagger.Module
import dagger.Provides

/**
 * Created by Franz Andel on 2019-08-28.
 * Android Engineer
 */

@Module
class DynamicFeatureModule {

    @Provides
    @ActivityScope
    fun provideHelper() = Helper()

}