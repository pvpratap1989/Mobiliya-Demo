package com.orange.mobiliya.di.builder

import com.orange.mobiliya.ui.rootScreen.RootActivity
import com.orange.mobiliya.ui.rootScreen.RootModule
import com.orange.mobiliya.ui.splashScreen.SplashModule
import com.orange.mobiliya.ui.splashScreen.SplashScreen
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule{
    @ContributesAndroidInjector(modules = [SplashModule::class])
    internal abstract fun contributeSplashActivity(): SplashScreen

    @ContributesAndroidInjector(modules = [RootModule::class])
    internal abstract fun contributeRootActivity(): RootActivity
}
