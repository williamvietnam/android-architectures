package com.base.mvvm.samples.ui.author

import androidx.lifecycle.SavedStateHandle
import com.base.mvvm.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AuthorSampleViewModel @Inject constructor(
    val savedStateHandle: SavedStateHandle
) : BaseViewModel() {
    init {
        Timber.tag("")
    }
}