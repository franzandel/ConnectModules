package com.example.dynamicfeature_test

import com.example.base.di.scope.ActivityScope
import com.example.base.di.scope.AppScope
import com.example.connectmodules.di.component.AppComponent
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Franz Andel on 2019-08-28.
 * Android Engineer
 */

@ActivityScope
@Component(
    modules = [DynamicFeatureModule::class],
    dependencies= [AppComponent::class]
)
interface DynamicFeatureComponent {

    fun inject(dynamicFeatureActivity: DynamicFeatureActivity)
}