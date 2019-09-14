package com.parcelnotfoundexception.javahack.di.modules

import com.parcelnotfoundexception.javahack.di.PerActivity
import com.parcelnotfoundexception.javahack.presentation.first.FirstActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppBuilderModule {

    @PerActivity
    @ContributesAndroidInjector
    fun provideFirstActivityFactory(): FirstActivity

}