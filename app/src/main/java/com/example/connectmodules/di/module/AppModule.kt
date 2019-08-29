package com.example.connectmodules.di.module

import com.example.base.di.module.BaseModule
import com.example.base.di.scope.AppScope
import com.example.base.router.ScreenRouter
import com.example.connectmodules.HelperApp
import com.example.connectmodules.router.ScreenRouterImpl
import dagger.Module
import dagger.Provides

/**
 * Created by Franz Andel on 2019-08-27.
 * Android Engineer
 */

@Module
class AppModule : BaseModule() {

    @Provides
    @AppScope
    fun provideScreenRouter() : ScreenRouter = ScreenRouterImpl()

    @Provides
    @AppScope
    fun provideHelperApp() : HelperApp = HelperApp()
}