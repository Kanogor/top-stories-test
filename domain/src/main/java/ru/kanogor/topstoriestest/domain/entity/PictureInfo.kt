package ru.kanogor.topstoriestest.domain.entity

interface PictureInfo {
    val results: List<ResultInfo>
}

interface ResultInfo {
    val multimedia: List<Multimedia>
}

interface Multimedia {
    val url: String
    val caption: String
}
