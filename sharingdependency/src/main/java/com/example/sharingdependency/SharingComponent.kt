package com.example.sharingdependency

import android.app.Application
import android.content.Context
import com.example.base.di.scope.AppScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Franz Andel on 2019-08-29.
 * Android Engineer
 */

//@AppScope
@Singleton
@Component(modules = [(SharingModule::class)])
interface SharingComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder
        fun build() : SharingComponent
    }

    fun inject(app: Application)

    fun helperApp() : HelperApp

}