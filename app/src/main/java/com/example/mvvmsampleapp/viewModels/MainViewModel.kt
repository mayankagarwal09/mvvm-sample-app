package com.example.mvvmsampleapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmsampleapp.models.Item
import com.example.mvvmsampleapp.models.Resource
import com.example.mvvmsampleapp.repositories.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val itemRepository: ItemRepository) : ViewModel() {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _itemList.value = Resource.error(throwable.message ?: "Something went wrong", null)
    }

    private val _itemList = MutableLiveData<Resource<List<Item>>>()

    val itemList: LiveData<Resource<List<Item>>>
        get() = _itemList

    fun getItemList() {
        viewModelScope.launch(coroutineExceptionHandler) {
            _itemList.value = Resource.loading(null)
            val response = itemRepository.loadItemList()
            if (response.status == "success") {
                _itemList.value = Resource.success(response.data.items)
            } else {
                _itemList.value = Resource.error(response.error ?: "Something went wrong", null)
            }
        }
    }
}