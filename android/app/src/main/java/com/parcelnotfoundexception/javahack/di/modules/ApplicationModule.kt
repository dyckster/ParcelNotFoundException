package com.parcelnotfoundexception.javahack.di.modules

import android.content.Context
import com.parcelnotfoundexception.javahack.di.PerApplication
import com.parcelnotfoundexception.javahack.App
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @PerApplication
    @Provides
    fun provideContext(application: App): Context = application

}