package ru.kanogor.topstoriestest.domain.usecase

import ru.kanogor.topstoriestest.domain.entity.PictureInfo
import ru.kanogor.topstoriestest.domain.repository.Repository

class GetPictureInfoUseCase(val repository: Repository) {
    suspend fun execute(): PictureInfo {
        return repository.getPictureInfo()
    }

}