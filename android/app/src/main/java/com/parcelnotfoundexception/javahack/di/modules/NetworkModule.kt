package com.parcelnotfoundexception.javahack.di.modules

import android.content.Context
import com.parcelnotfoundexception.javahack.data.network.JavaHackApi
import com.parcelnotfoundexception.javahack.di.PerApplication
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @PerApplication
    @Provides
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @PerApplication
    @Provides
    fun provideOkHttpClient(
        context: Context,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(httpLoggingInterceptor)
        httpClient.addInterceptor {
            val request = it.request().newBuilder().addHeader("USER-ID", DEFAULT_USER_ID).build()
            return@addInterceptor it.proceed(request)
        }
        return httpClient.build()
    }

    @Provides
    @PerApplication
    fun provideAppApi(httpClient: OkHttpClient): JavaHackApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(httpClient)
            .baseUrl("http://ae0139d4.ngrok.io/api/")
            .build()
            .create(JavaHackApi::class.java)
    }

    companion object {
        private const val DEFAULT_USER_ID = "066269f7-40e1-49bc-a612-366ef6de9f13"
    }

}