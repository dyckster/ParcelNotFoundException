package com.parcelnotfoundexception.javahack.di

import com.parcelnotfoundexception.javahack.App
import com.parcelnotfoundexception.javahack.di.modules.AppBuilderModule
import com.parcelnotfoundexception.javahack.di.modules.ApplicationModule
import com.parcelnotfoundexception.javahack.di.modules.NetworkModule
import com.parcelnotfoundexception.javahack.di.modules.RepositoryModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@PerApplication
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppBuilderModule::class,
        ApplicationModule::class,
        RepositoryModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

}