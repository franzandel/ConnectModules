package com.example.connectmodules.di.module.builder

import com.example.base.di.scope.ActivityScope
import com.example.connectmodules.di.module.MainActivityModule
import com.example.connectmodules.presentation.MainActivity
import com.example.testingactivity.presentation.TestActivity
import com.example.testingactivity.di.TestModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Franz Andel on 2019-08-27.
 * Android Engineer
 */

@Module
abstract class ActivityBuilder {
    @ActivityScope
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity() : MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(TestModule::class)])
    abstract fun bindTestActivity() : TestActivity

}