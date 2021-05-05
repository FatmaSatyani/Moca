package com.fatmasatyani.moca.di

import android.app.Application
import com.fatmasatyani.moca.source.local.LocalRepository
import com.fatmasatyani.moca.source.remote.ListRepository
import com.fatmasatyani.moca.source.remote.RemoteRepository

class Injection {

    companion object {
        fun provideRepository(application: Application): ListRepository {
            val localRepository = LocalRepository.getInstance(application)
            val remoteRepository = RemoteRepository.getInstance()
            return ListRepository.getInstance(remoteRepository, localRepository)

        }
    }
}