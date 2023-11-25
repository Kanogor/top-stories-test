package ru.kanogor.topstoriestest.di

import org.koin.dsl.module
import ru.kanogor.topstoriestest.domain.usecase.GetPictureInfoUseCase

val domainModule = module {

    factory {
        GetPictureInfoUseCase(repository = get())
    }

}