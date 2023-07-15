package com.base.mvvm.core.module

import android.content.Context
import android.text.TextUtils
import com.base.mvvm.core.data.network.ApiEndpoint
import com.base.mvvm.core.data.network.ApiServices
import com.base.mvvm.core.data.network.AuthenticationApiServices
import com.base.mvvm.core.data.network.utilities.NetworkInterceptor
import com.base.mvvm.core.data.preferences.PreferencesHelper
import com.base.mvvm.core.utilities.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().setLenient().create()
    }

    @Provides
    @Singleton
    fun provideApiServices(gson: Gson, client: OkHttpClient): ApiServices {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiEndpoint.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit.create(ApiServices::class.java)
    }


    @Provides
    @Singleton
    fun provideAuthenticationApiServices(
        gson: Gson,
        client: OkHttpClient
    ): AuthenticationApiServices {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiEndpoint.BASE_URL)
            .client(client)
            .addConverterFactory(NullOnEmptyConverterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit.create(AuthenticationApiServices::class.java)
    }

    @Provides
    @Singleton
    fun provideHttpClient(cache: Cache?, preferencesHelper: PreferencesHelper): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(Interceptor { chain: Interceptor.Chain ->
                val request = if (!TextUtils.isEmpty(preferencesHelper.getToken())) {
                    chain.request()
                        .newBuilder()
                        .header("Content-Type", "application/json")
                        .addHeader(
                            "Authorization", preferencesHelper.getToken()!!
                        )
                        .build()
                } else {
                    chain.request()
                        .newBuilder()
                        .header("Content-Type", "application/json")
                        .build()
                }

                chain.proceed(request)
            })
            .addInterceptor(loggingInterceptor)
            .addInterceptor(NetworkInterceptor())
            .connectTimeout(Constants.DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(Constants.DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(Constants.DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideCache(@ApplicationContext application: Context): Cache {
        val cacheSize = 10 * 1024 * 1024.toLong() // 10 MB
        val httpCacheDirectory = File(application.cacheDir, "http-cache")
        return Cache(httpCacheDirectory, cacheSize)
    }

    @Provides
    fun provideGsonClient(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
}

class NullOnEmptyConverterFactory : Converter.Factory() {
    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *> {
        val delegate: Converter<ResponseBody, Any> =
            retrofit.nextResponseBodyConverter(this, type, annotations)
        return Converter { body -> if (body.contentLength() == 0L) null else delegate.convert(body) }
    }
}