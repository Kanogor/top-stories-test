package ru.kanogor.topstoriestest.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.kanogor.topstoriestest.data.dto.PictureInfoDto

interface SearchApiInfo {

    @GET("arts.json")
    suspend fun getPictureInfo(
        @Query("api-key") apiKey: String = API_KEY
    ): Response<PictureInfoDto>


}