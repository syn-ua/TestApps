package com.test.testapp.interfaces.services

import android.view.View
import androidx.lifecycle.LiveData

interface VideoService {
    suspend fun startVideo(url: String)
    suspend fun stopVideo()

    suspend fun getVideoList(): LiveData<List<String>>
    suspend fun getView(): View
}