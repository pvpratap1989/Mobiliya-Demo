package com.orange.mobiliya.ui.splashScreen

import androidx.lifecycle.ViewModelProvider
import com.orange.mobiliya.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class SplashModule{
    @Provides
    internal fun SpalshViewModelProvider(splashViewModel: SplashViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(splashViewModel)
    }

    @Provides
    internal fun provideSplashViewModel(): SplashViewModel {
        return SplashViewModel()
    }
}