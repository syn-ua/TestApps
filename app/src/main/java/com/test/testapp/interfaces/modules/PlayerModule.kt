package com.test.testapp.interfaces.modules

import android.view.View

interface PlayerModule {
    suspend fun setUrl(url: String)
    suspend fun start()
    suspend fun stop()
    suspend fun init();
    suspend fun getView(): View

}