package com.orange.mobiliya.di.component

import android.app.Application
import com.orange.mobiliya.MobiliyaApp
import com.orange.mobiliya.di.builder.ActivityBuildersModule
import com.orange.mobiliya.di.module.AppModule

import javax.inject.Singleton
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityBuildersModule::class])
interface AppComponent : AndroidInjector<MobiliyaApp> {

    override fun inject(app: MobiliyaApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}
