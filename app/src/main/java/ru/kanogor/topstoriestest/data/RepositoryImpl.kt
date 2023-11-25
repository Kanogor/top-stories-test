package ru.kanogor.topstoriestest.data

import ru.kanogor.topstoriestest.domain.entity.PictureInfo
import ru.kanogor.topstoriestest.domain.repository.Repository

class RepositoryImpl(private val searchApiInfo: SearchApiInfo) : Repository {
    override suspend fun getPictureInfo(): PictureInfo {
        return searchApiInfo.getPictureInfo().body()!!
    }
}