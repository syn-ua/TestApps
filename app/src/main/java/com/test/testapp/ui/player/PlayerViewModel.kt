package com.test.testapp.ui.player

import android.content.Context
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.exoplayer2.metadata.Metadata
import com.test.testapp.interfaces.services.VideoService
import com.test.testapp.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlayerViewModel @Inject constructor(
    context: Context,
    private val videoService: VideoService
) : BaseViewModel(context) {

    val playerList: LiveData<List<String>> = videoService.getVideoList()
    val metadata: LiveData<Metadata> = videoService.getMetaData()
    val playerView: MutableLiveData<View> = MutableLiveData()


    fun init() {
        viewModelScope.launch(IO + handler) {
            playerView.postValue(videoService.getView())
        }
    }

    fun stop() {
        viewModelScope.launch(IO + handler) {
            videoService.stopVideo()
        }
    }

    fun start(url: String) {
        viewModelScope.launch(IO + handler) {
            videoService.startVideo(url)
        }
    }
}