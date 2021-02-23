package com.test.testapp.services.video

import androidx.lifecycle.LiveData
import com.test.testapp.interfaces.services.VideoService

class VideoServiceImpl : VideoService {
    override suspend fun startVideo(url: String) {
        TODO("Not yet implemented")
    }

    override suspend fun stopVideo() {
        TODO("Not yet implemented")
    }

    override suspend fun getVideoList(): LiveData<List<String>> {
        TODO("Not yet implemented")
    }
}