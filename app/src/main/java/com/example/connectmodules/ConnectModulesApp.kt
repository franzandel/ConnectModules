package com.example.connectmodules

import android.app.Activity
import android.app.Application
import com.example.connectmodules.di.component.AppComponent
import com.example.connectmodules.di.component.DaggerAppComponent
import com.example.connectmodules.di.module.AppModule
import com.example.sharingdependency.DaggerSharingComponent
import com.example.sharingdependency.HelperApp
import com.example.sharingdependency.SharingComponent
import com.example.sharingdependency.SharingModule
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
        @JvmStatic
        lateinit var sharingComponent : SharingComponent
    }

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        appComponent = createComponent()
        appComponent.inject(this)
//        appComponent.plusSharingComponent(sharingComponent)

        sharingComponent = createSharingComponent()
        sharingComponent.inject(this)
    }

    private fun createComponent() : AppComponent{
        return DaggerAppComponent.builder()
            .application(this)
            .build()

        // OLD BUILDER
//        return DaggerAppComponent.builder()
//            .appModule(AppModule())
//            .build()
    }

    private fun createSharingComponent(): SharingComponent {
        return DaggerSharingComponent.builder()
            .application(this)
            .build()

        // OLD BUILDER
//        return DaggerSharingComponent.builder()
//            .sharingModule(SharingModule())
//            .build()
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }
}