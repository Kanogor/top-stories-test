package ru.kanogor.topstoriestest.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.kanogor.topstoriestest.presentation.MainViewModel

val appModule = module {

    viewModel {
        MainViewModel(getPictureInfoUseCase = get())
    }

}