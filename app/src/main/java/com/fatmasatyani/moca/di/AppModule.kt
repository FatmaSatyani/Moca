package com.fatmasatyani.moca.di

import com.fatmasatyani.core.domain.usecase.Interactor
import com.fatmasatyani.core.domain.usecase.MocaUseCase
import com.fatmasatyani.moca.movie.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory <MocaUseCase>{ Interactor(get()) }
}

@ExperimentalCoroutinesApi
@FlowPreview
val viewModelModule = module {
    viewModel { HomeViewModel(get()) }

}

