package com.test.testapp.services.video

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.testapp.interfaces.modules.ApiModule
import com.test.testapp.interfaces.modules.PlayerModule
import com.test.testapp.interfaces.services.VideoService
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class VideoServiceImpl @Inject constructor(
    private val playerModule: PlayerModule,
    private val apiModule: ApiModule

) : VideoService {
    private val listStreams: MutableLiveData<List<String>> = MutableLiveData();


    override suspend fun startVideo(url: String) {
        playerModule.setUrl(url)
        playerModule.start()
    }

    override suspend fun stopVideo() = playerModule.stop()

    override fun getVideoList(): LiveData<List<String>> {
        if (listStreams.value == null || listStreams.value!!.isEmpty()) {
            GlobalScope.launch(IO) {
                listStreams.postValue(apiModule.getStreamsAddresses())
            }
        }
        return listStreams;
    }

    override suspend fun getView() = playerModule.getView()
}