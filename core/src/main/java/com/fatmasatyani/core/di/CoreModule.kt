package com.fatmasatyani.core.di

import androidx.room.Room
import com.fatmasatyani.core.data.source.MovieCatalogueRepository
import com.fatmasatyani.core.data.source.RemoteDataSource
import com.fatmasatyani.core.data.source.local.AppDatabase
import com.fatmasatyani.core.data.source.local.LocalDataSource
import com.fatmasatyani.core.domain.repository.IMocaRepository
import com.fatmasatyani.core.network.ApiConfig
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    val tableName = "db_favorite"

    factory { get<AppDatabase>().movieDao() }
//    factory { get<AppDatabase>().tvShowDao() }

    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("moca".toCharArray())
        val factory = SupportFactory(passphrase)

        Room.databaseBuilder(
            androidContext(), AppDatabase::class.java, tableName
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        ApiConfig.getApiService()
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    single<IMocaRepository> { MovieCatalogueRepository(get(), get()) }
}
