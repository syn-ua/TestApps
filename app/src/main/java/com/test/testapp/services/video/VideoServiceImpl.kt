package com.test.testapp.services.video

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.testapp.interfaces.modules.ApiModule
import com.test.testapp.interfaces.modules.PlayerModule
import com.test.testapp.interfaces.services.VideoService
import javax.inject.Inject

class VideoServiceImpl @Inject constructor(
    private val playerModule: PlayerModule,
    private val apiModule: ApiModule

) : VideoService {
    private val listStreams: MutableLiveData<List<String>> = MutableLiveData();
    override suspend fun startVideo(url: String) = playerModule.setUrl(url)

    override suspend fun stopVideo() = playerModule.stop()

    override suspend fun getVideoList(): LiveData<List<String>> {
        if (listStreams.value == null || listStreams.value!!.isEmpty()) {
            listStreams.postValue(apiModule.getStreamsAddresses())
        }
        return listStreams;
    }

    override suspend fun getView() = playerModule.getView()
}