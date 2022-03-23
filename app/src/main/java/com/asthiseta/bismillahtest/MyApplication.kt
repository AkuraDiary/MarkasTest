package com.asthiseta.bismillahtest

import android.app.Application
import com.asthiseta.bismillahtest.di.useCaseModule
import com.asthiseta.bismillahtest.di.viewModelModule
import com.asthiseta.core.di.networkModule
import com.asthiseta.core.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}