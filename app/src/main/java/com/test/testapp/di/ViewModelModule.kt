package com.test.testapp.di

import androidx.lifecycle.ViewModel
import com.test.testapp.di.utils.ViewModelKey
import com.test.testapp.ui.player.PlayerViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PlayerViewModel::class)
    abstract fun bindViewModel(viewModel: PlayerViewModel): ViewModel

}