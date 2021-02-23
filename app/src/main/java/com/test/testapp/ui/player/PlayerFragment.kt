package com.test.testapp.ui.player

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.test.testapp.R
import com.test.testapp.ui.base.BaseFragment
import kotlinx.android.synthetic.main.screen_player.*


class PlayerFragment : BaseFragment(R.layout.screen_player) {

    private val viewModel by viewModels<PlayerViewModel> { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.init();
        viewModel.playerView.observe(viewLifecycleOwner, Observer { updatePlayerView(it) })
        viewModel.playerList.observe(viewLifecycleOwner, Observer {
            viewModel.start(it[0]);
        })

        viewModel.metadata.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
        })

    }

    private fun updatePlayerView(playerView: View?) {
        if (playerView == null) {
            return
        }
        playerRootView.removeAllViews()
        (playerView.parent as? ViewGroup)?.removeView(playerView)
        playerRootView.addView(playerView)
    }

    override fun onPause() {
        super.onPause()
        viewModel.stop();
    }
}