package com.fatmasatyani.moca

import android.app.Application
import com.fatmasatyani.core.di.databaseModule
import com.fatmasatyani.core.di.networkModule
import com.fatmasatyani.core.di.repositoryModule
import com.fatmasatyani.moca.di.useCaseModule
import com.fatmasatyani.moca.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                databaseModule,
                viewModelModule,
                networkModule,
                repositoryModule,
                useCaseModule
            )
        }
    }
}