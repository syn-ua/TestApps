package com.test.testapp.ui.player

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.test.testapp.R
import com.test.testapp.ui.base.BaseFragment


class PlayerFragment : BaseFragment(R.layout.screen_player) {

    private val viewModel by viewModels<PlayerViewModel> { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.init();
        viewModel.playerView.observe(viewLifecycleOwner, Observer { updatePlayerView(it) })

    }

    private fun updatePlayerView(playerView: View?) {
        if (playerView == null) {
            return
        }

    }

}