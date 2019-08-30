package com.example.sharingdependency

import android.app.Application
import android.content.Context
import com.example.base.di.module.BaseModule
import com.example.base.di.scope.AppScope
import com.example.base.router.ScreenRouter
import dagger.Module
import dagger.Provides
import dagger.Reusable

/**
 * Created by Franz Andel on 2019-08-29.
 * Android Engineer
 */

@Module
class SharingModule {

    @Provides
    @Reusable
    fun provideHelperApp() : HelperApp = HelperApp()
}