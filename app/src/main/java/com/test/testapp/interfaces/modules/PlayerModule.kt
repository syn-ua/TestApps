package com.test.testapp.interfaces.modules

import android.view.View
import androidx.lifecycle.LiveData
import com.google.android.exoplayer2.metadata.Metadata

interface PlayerModule {
    suspend fun setUrl(url: String)
    suspend fun start()
    suspend fun stop()
    suspend fun getView(): View


    fun getMetaData(): LiveData<Metadata>
}