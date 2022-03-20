package com.asthiseta.core.di

import org.koin.dsl.module
import com.asthiseta.core.BuildConfig

private const val BASE_URL = BuildConfig.BASE_URL
private const val API_KEY = BuildConfig.API_KEY

val networkModule = module {
    single {

    }
}