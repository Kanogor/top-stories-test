package ru.kanogor.topstoriestest.di

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.kanogor.topstoriestest.data.RepositoryImpl
import ru.kanogor.topstoriestest.data.SearchApiInfo
import ru.kanogor.topstoriestest.domain.repository.Repository

private const val BASE_URL = "https://api.nytimes.com/svc/topstories/v2/"

val dataModule = module {

    single<Repository> {
        RepositoryImpl(searchApiInfo = get())
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    factory {
        get<Retrofit>().create(SearchApiInfo::class.java)
    }


}