package com.test.testapp.di

import com.test.testapp.interfaces.services.VideoService
import com.test.testapp.services.video.VideoServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun videoServiceProvide(videoService: VideoServiceImpl) = videoService as VideoService

}