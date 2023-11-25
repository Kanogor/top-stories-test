package ru.kanogor.topstoriestest.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ru.kanogor.topstoriestest.domain.entity.Multimedia
import ru.kanogor.topstoriestest.domain.entity.PictureInfo
import ru.kanogor.topstoriestest.domain.entity.ResultInfo

@JsonClass(generateAdapter = true)
data class PictureInfoDto(
    @Json(name = "results")
    override val results: List<ResultInfoDto>
) : PictureInfo

@JsonClass(generateAdapter = true)
data class ResultInfoDto(
    @Json(name = "multimedia")
    override val multimedia: List<MultimediaDto>
) : ResultInfo

@JsonClass(generateAdapter = true)
data class MultimediaDto(
    @Json(name = "url")
    override val url: String,
    @Json(name = "caption")
    override val caption: String
) : Multimedia
