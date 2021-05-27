//package com.fatmasatyani.moca.viewmodel
//
//import android.app.Application
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.fatmasatyani.core.data.source.MovieCatalogueRepository
//import com.fatmasatyani.moca.detail.DetailMovieViewModel
//import com.fatmasatyani.moca.detail.DetailTvShowViewModel
//import com.fatmasatyani.moca.di.Injection
//import com.fatmasatyani.moca.movie.MovieViewModel
//import com.fatmasatyani.moca.tvshow.TvShowViewModel
//
//class ViewModelFactory private constructor(private val listRepository: MovieCatalogueRepository): ViewModelProvider.NewInstanceFactory(){
//
//    companion object {
//        @Volatile
//        private var instance: ViewModelFactory? = null
//
//        fun getInstance (application: Application): ViewModelFactory =
//            instance?: synchronized(this) {
//                instance?:ViewModelFactory(Injection.provideRepository(application)).apply {
//                    instance = this
//                }
//            }
//    }
//
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return when {
//            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> DetailMovieViewModel(listRepository) as (T)
//            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> DetailTvShowViewModel(listRepository) as (T)
//            modelClass.isAssignableFrom(MovieViewModel::class.java) -> MovieViewModel(listRepository) as (T)
//            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> TvShowViewModel(listRepository) as (T)
////            modelClass.isAssignableFrom(com.fatmasatyani.favorite.movie.FavoriteMovieViewModel::class.java) -> com.fatmasatyani.favorite.movie.FavoriteMovieViewModel(
////                listRepository
////            ) as (T)
////            modelClass.isAssignableFrom(com.fatmasatyani.favorite.tvshow.FavoriteTvShowViewModel::class.java) -> com.fatmasatyani.favorite.tvshow.FavoriteTvShowViewModel(
////                listRepository
////            ) as (T)
//
//            else ->  throw IllegalArgumentException("Unknown ViewModel class" + modelClass.name)
//        }
//    }
//}