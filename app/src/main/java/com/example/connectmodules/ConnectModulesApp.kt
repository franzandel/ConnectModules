package com.example.connectmodules

import android.app.Activity
import android.app.Application
import com.example.connectmodules.di.component.AppComponent
import com.example.connectmodules.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Franz Andel on 2019-08-27.
 * Android Engineer
 */

class ConnectModulesApp : Application(), HasActivityInjector {
    companion object {
        @JvmStatic
        lateinit var appComponent : AppComponent
    }

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        appComponent = createComponent()
        appComponent.inject(this)
    }

    private fun createComponent() : AppComponent{
        return DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }
}