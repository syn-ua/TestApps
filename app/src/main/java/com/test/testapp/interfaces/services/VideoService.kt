package com.test.testapp.interfaces.services

import android.view.View
import androidx.lifecycle.LiveData
import com.google.android.exoplayer2.metadata.Metadata

interface VideoService {
    suspend fun startVideo(url: String)
    suspend fun stopVideo()

    fun getVideoList(): LiveData<List<String>>
    fun getMetaData(): LiveData<Metadata>
    suspend fun getView(): View
}