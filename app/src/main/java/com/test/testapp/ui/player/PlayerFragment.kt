package com.test.testapp.ui.player

import androidx.fragment.app.viewModels
import com.test.testapp.R
import com.test.testapp.ui.base.BaseFragment


class PlayerFragment : BaseFragment(R.layout.screen_player) {

    private val viewModel by viewModels<PlayerViewModel> { viewModelFactory }


}