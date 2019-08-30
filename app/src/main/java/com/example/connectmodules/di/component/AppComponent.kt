package com.example.connectmodules.di.component

import android.app.Application
import com.example.base.di.scope.AppScope
import com.example.connectmodules.ConnectModulesApp
//import com.example.connectmodules.HelperApp
import com.example.connectmodules.di.module.AppModule
import com.example.connectmodules.di.module.builder.ActivityBuilder
import com.example.sharingdependency.SharingComponent
import com.example.sharingdependency.SharingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

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

    fun plusSharingComponent(sharingComponent: SharingComponent) : SharingComponent
}

//@AppScope
//@Component(modules = [(AndroidInjectionModule::class),
//    (AppModule::class),
//    (ActivityBuilder::class)
//], dependencies = [(SharingComponent::class)])
//interface AppComponent {
//
//    @Component.Builder
//    interface Builder {
//        @BindsInstance
//        fun application(application: Application) : Builder
//        fun build() : AppComponent
//    }
//
//    fun inject(app: ConnectModulesApp)
//
////    fun helperApp() : HelperApp
//}