package com.parcelnotfoundexception.javahack.di.modules

import com.parcelnotfoundexception.javahack.di.PerActivity
import com.parcelnotfoundexception.javahack.presentation.dashboard.DashboardActivity
import com.parcelnotfoundexception.javahack.presentation.story.ArticleStoryActivity
import com.parcelnotfoundexception.javahack.presentation.timeline.TimelineActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppBuilderModule {

    @PerActivity
    @ContributesAndroidInjector
    fun provideDashboardActivityFactory(): DashboardActivity

    @PerActivity
    @ContributesAndroidInjector
    fun provideTimelineActivityFactory(): TimelineActivity

    @PerActivity
    @ContributesAndroidInjector
    fun provideArticleStoryFactory(): ArticleStoryActivity
}