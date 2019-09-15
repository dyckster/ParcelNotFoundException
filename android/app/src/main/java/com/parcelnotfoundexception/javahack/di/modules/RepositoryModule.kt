package com.parcelnotfoundexception.javahack.di.modules

import com.parcelnotfoundexception.javahack.data.network.JavaHackApi
import com.parcelnotfoundexception.javahack.data.repository.AppArticleRepository
import com.parcelnotfoundexception.javahack.data.repository.AppDashboardRepository
import com.parcelnotfoundexception.javahack.data.repository.AppTimelineRepository
import com.parcelnotfoundexception.javahack.di.PerApplication
import com.parcelnotfoundexception.javahack.domain.repository.ArticleRepository
import com.parcelnotfoundexception.javahack.domain.repository.DashboardRepository
import com.parcelnotfoundexception.javahack.domain.repository.TimelineRepository
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class RepositoryModule {

    @Provides
    fun provideDashboardRepository(api: JavaHackApi): DashboardRepository =
        AppDashboardRepository(api)

    @Provides
    fun provideTimelineRepository(api: JavaHackApi): TimelineRepository =
        AppTimelineRepository(api)

    @Provides
    @PerApplication
    fun provideArticleRepository(api: JavaHackApi): ArticleRepository = AppArticleRepository(api)
}