package com.fatmasatyani.di

//import com.fatmasatyani.favorite.tvshow.FavoriteTvShowViewModel
import com.fatmasatyani.favorite.movie.FavoriteMovieViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteMovieModule = module {
    viewModel { FavoriteMovieViewModel(get()) }
}

//val favoriteTvShowModule = module {
//    viewModel { FavoriteTvShowViewModel(get()) }
//}
