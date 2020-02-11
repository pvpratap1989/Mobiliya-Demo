package com.orange.mobiliya.ui.rootScreen

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.orange.mobiliya.ViewModelProviderFactory
import com.orange.mobiliya.adapters.RepoAdapter
import com.orange.mobiliya.ui.splashScreen.SplashViewModel
import dagger.Module
import dagger.Provides

@Module
class RootModule {
    @Provides
    internal fun RootViewModelProvider(rootViewModel: RootViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(rootViewModel)
    }

    @Provides
    internal fun provideRootViewModel(): RootViewModel {
        return RootViewModel()
    }

    @Provides
    fun provideLinearLayoutManager(rootScreen: RootActivity): LinearLayoutManager {
        return LinearLayoutManager(rootScreen)
    }
//
//    @Provides
//    fun provideRepoAdapter(): RepoAdapter {
//        return RepoAdapter()
//    }

}