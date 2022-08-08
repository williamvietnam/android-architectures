package com.base.mvvm.samples.ui.container

import androidx.lifecycle.SavedStateHandle
import com.base.mvvm.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainSampleViewModel @Inject constructor(
    val savedStateHandle: SavedStateHandle
) : BaseViewModel() {
    init {
        //todo
    }
}