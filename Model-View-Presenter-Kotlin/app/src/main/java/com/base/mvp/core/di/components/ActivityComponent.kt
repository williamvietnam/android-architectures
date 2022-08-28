package com.base.mvp.core.di.components

import com.base.mvp.core.di.PerActivity
import com.base.mvp.core.di.modules.ActivityModule
import dagger.Component

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
}