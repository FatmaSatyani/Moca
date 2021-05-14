package com.fatmasatyani.moca.di

import android.app.Application
import com.fatmasatyani.moca.source.local.LocalDataSource
import com.fatmasatyani.moca.source.remote.MovieCatalogueRepository
import com.fatmasatyani.moca.source.remote.RemoteDataSource
import com.fatmasatyani.moca.utils.AppExecutors

class Injection {

    companion object {
        fun provideRepository(application: Application): MovieCatalogueRepository {
            val localRepository = LocalDataSource.getInstance(application)
            val remoteRepository = RemoteDataSource.getInstance()
            val appExecutors = AppExecutors()
            return MovieCatalogueRepository.getInstance(remoteRepository, localRepository, appExecutors)

        }
    }
}