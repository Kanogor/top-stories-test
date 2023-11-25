package ru.kanogor.topstoriestest.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.kanogor.topstoriestest.domain.entity.Multimedia
import ru.kanogor.topstoriestest.domain.usecase.GetPictureInfoUseCase

class MainViewModel(val getPictureInfoUseCase: GetPictureInfoUseCase) : ViewModel() {

    private val _multimedia = MutableStateFlow<List<Multimedia>>(emptyList())
    val multimedia = _multimedia.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private fun getInfo() {
        _isLoading.value = true
        viewModelScope.launch {
            kotlin.runCatching {
                getPictureInfoUseCase.execute()
            }.fold(
                onSuccess = { result ->
                    // добавляем файлы из списка мультимедии
                    val list: MutableList<Multimedia> = mutableListOf()
                    result.results.onEach {
                        it.multimedia.onEach { multimedia ->
                            list.add(multimedia)
                        }
                    }
                    // удаляем повторяющиеся элементы
                    val distinctList = list.distinctBy { it.caption }
                    _multimedia.value = distinctList
                    _isLoading.value = false
                },
                onFailure = {
                    Log.d("MainVM", "onFailure = ${it.message}")
                }
            )
        }
    }

    init {
        getInfo()
    }

}