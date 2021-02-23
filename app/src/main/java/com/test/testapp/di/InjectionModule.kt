package com.test.testapp.di

import com.test.testapp.di.utils.ViewModelBuilder
import com.test.testapp.ui.navigation.MainActivity
import com.test.testapp.ui.player.PlayerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class InjectionModule {

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class, ViewModelModule::class])
    internal abstract fun mainActivityInjector(): MainActivity

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class, ViewModelModule::class])
    internal abstract fun playerFragmentInjector(): PlayerFragment

}