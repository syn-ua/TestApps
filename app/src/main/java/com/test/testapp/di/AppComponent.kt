package com.test.testapp.di

import android.content.Context
import com.test.testapp.TestApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/**
 * Main component for the application.
 *
 */
@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        AllModules::class,
        ServiceModule::class,
        AndroidSupportInjectionModule::class,
        InjectionModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<TestApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}
