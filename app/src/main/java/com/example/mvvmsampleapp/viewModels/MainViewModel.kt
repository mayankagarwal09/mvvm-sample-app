package com.example.mvvmsampleapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.mvvmsampleapp.models.Item
import com.example.mvvmsampleapp.repositories.ItemRepository
import com.example.mvvmsampleapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    itemRepository: ItemRepository
) : ViewModel() {

    private val _itemList = itemRepository.loadItemList().asLiveData()

    val itemList: LiveData<Resource<List<Item>>>
        get() = _itemList
}