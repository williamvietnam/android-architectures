package com.base.mvp.core.di.components

import com.base.mvp.core.di.modules.BroadcastReceiverModule
import dagger.Component

@Component(modules = [BroadcastReceiverModule::class])
interface BroadcastReceiverComponent {
}