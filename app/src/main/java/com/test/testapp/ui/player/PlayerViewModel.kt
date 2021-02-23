package com.test.testapp.ui.player

import android.content.Context
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.test.testapp.interfaces.services.VideoService
import com.test.testapp.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlayerViewModel @Inject constructor(
    context: Context,
    private val videoService: VideoService
) : BaseViewModel(context) {

    val playerView: MutableLiveData<View> = MutableLiveData()


    fun init() {
        viewModelScope.launch(IO + handler) {
            playerView.postValue(videoService.getView())
        }
    }
}