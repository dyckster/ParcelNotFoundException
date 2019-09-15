package com.parcelnotfoundexception.javahack.data.repository

import com.parcelnotfoundexception.javahack.data.network.JavaHackApi
import com.parcelnotfoundexception.javahack.domain.model.dashboard.Dashboard
import com.parcelnotfoundexception.javahack.domain.repository.DashboardRepository
import io.reactivex.Single

class AppDashboardRepository(private val api: JavaHackApi) : DashboardRepository {

    override fun getDashboard(): Single<Dashboard> = api.getDashboard()

}