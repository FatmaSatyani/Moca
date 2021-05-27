package com.fatmasatyani.moca.di

import android.app.Application
import com.fatmasatyani.core.data.source.local.LocalDataSource
import com.fatmasatyani.core.data.source.MovieCatalogueRepository
import com.fatmasatyani.core.data.source.RemoteDataSource
import com.fatmasatyani.core.data.source.local.AppDatabase.Companion.getInstance
import com.fatmasatyani.core.data.source.local.LocalDataSource.Companion.getInstance
import com.fatmasatyani.moca.utils.AppExecutors
//import com.fatmasatyani.moca.viewmodel.ViewModelFactory.Companion.getInstance

//class Injection {
//
//    companion object {
//        fun provideRepository(application: Application): MovieCatalogueRepository {
//            val localRepository = LocalDataSource.getInstance(application)
//            val remoteRepository = RemoteDataSource.getInstance()
//            val appExecutors = AppExecutors()
//            return MovieCatalogueRepository.getInstance(remoteRepository, localRepository, appExecutors)
//
//        }
//    }
//}