package com.test.testapp.modules.exo

import android.content.Context
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.test.testapp.interfaces.modules.PlayerModule
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class ExoPlayerModule @Inject constructor(
    private val context: Context
) : PlayerModule {
    var player = SimpleExoPlayer.Builder(context).build()
    private val view: StyledPlayerView = StyledPlayerView(context);

    init {
        view.player = player
        player.setThrowsWhenUsingWrongThread(false)
    }


    override suspend fun setUrl(url: String) {
        val mediaItem: MediaItem = MediaItem.fromUri(url)
        GlobalScope.launch(Main) {
            player.setMediaItem(mediaItem)
            player.prepare()
        }

    }

    override suspend fun start() {
        player.play()
    }

    override suspend fun stop() {
        player.stop()
    }


    override suspend fun getView() = view;
}