package com.example.mvvmsampleapp.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmsampleapp.models.Item
import com.example.mvvmsampleapp.repositories.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val itemRepository: ItemRepository) : ViewModel() {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.d(javaClass.simpleName, "error: ${throwable.localizedMessage}")
    }

    private val _itemList = MutableLiveData<List<Item>>()

    val itemList: LiveData<List<Item>>
        get() = _itemList

    fun getItemList() {
        viewModelScope.launch(coroutineExceptionHandler) {
            val response = itemRepository.loadItemList()
            if (response.status == "success") {
                _itemList.value = response.data.items
            }
        }
    }
}