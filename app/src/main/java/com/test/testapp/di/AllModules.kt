package com.test.testapp.di

import com.test.testapp.interfaces.modules.ApiModule
import com.test.testapp.interfaces.modules.PlayerModule
import com.test.testapp.modules.exo.ExoPlayerModule
import com.test.testapp.modules.mock.MockApiModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AllModules {

    @Provides
    @Singleton
    fun provideApiModule(apiModule: MockApiModule) = apiModule as ApiModule

    @Provides
    @Singleton
    fun providePlayerModule(playerModule: ExoPlayerModule) = playerModule as PlayerModule


}