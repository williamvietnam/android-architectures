package com.base.mvp.core.di.components

import com.base.mvp.core.di.modules.ServiceModule
import dagger.Component

@Component(modules = [ServiceModule::class])
interface ServiceComponent {
}