package ru.kanogor.topstoriestest.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.kanogor.topstoriestest.domain.entity.Multimedia
import ru.kanogor.topstoriestest.domain.usecase.GetPictureInfoUseCase

class MainViewModel(val getPictureInfoUseCase: GetPictureInfoUseCase) : ViewModel() {

    fun getInfo() {
        viewModelScope.launch {
            kotlin.runCatching {
                getPictureInfoUseCase.execute()
            }.fold(
                onSuccess = { result ->
                    val list: MutableList<Multimedia> = mutableListOf()
                    result.results.onEach {
                        it.multimedia.onEach { multimedia ->
                            list.add(multimedia)
                        }
                    }
                    Log.d("MainVM", "onSuccess = $list")
                },
                onFailure = {
                    Log.d("MainVM", "onFailure = ${it.message}")
                }
            )
        }
    }

}