package com.example.base.di.module

import android.app.Application
import android.content.Context
import com.example.base.di.scope.AppScope
import dagger.Module
import dagger.Provides

/**
 * Created by Franz Andel on 2019-08-27.
 * Android Engineer
 */

@Module
abstract class BaseModule {

    @Provides
    @AppScope
    fun provideContext(application: Application) : Context = application
}