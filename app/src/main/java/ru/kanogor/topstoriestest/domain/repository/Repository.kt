package ru.kanogor.topstoriestest.domain.repository

import ru.kanogor.topstoriestest.domain.entity.PictureInfo

interface Repository {

    suspend fun getPictureInfo() : PictureInfo

}