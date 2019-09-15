package com.parcelnotfoundexception.javahack.domain.repository

import com.parcelnotfoundexception.javahack.domain.model.dashboard.Dashboard
import io.reactivex.Single

interface DashboardRepository {

    fun getDashboard(): Single<Dashboard>

}