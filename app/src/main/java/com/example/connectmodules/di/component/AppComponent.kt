package com.example.connectmodules.di.component

import android.app.Application
import com.example.base.di.scope.AppScope
import com.example.connectmodules.ConnectModulesApp
import com.example.connectmodules.di.module.AppModule
import com.example.connectmodules.di.module.builder.ActivityBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

/**
 * Created by Franz Andel on 2019-08-27.
 * Android Engineer
 */

@AppScope
@Component(modules = [(AndroidInjectionModule::class),
    (AppModule::class),
    (ActivityBuilder::class)
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder
        fun build() : AppComponent
    }

    fun inject(app: ConnectModulesApp)
}