package com.example.randomquote.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomquote.entity.Response
import com.example.randomquote.network.RandomQuoteApi
import kotlinx.coroutines.launch

class OrderViewModel:ViewModel() {

    private val _quoteStatus = MutableLiveData<Response>()
    val quoteStatus: LiveData<Response> = _quoteStatus

    init {
        getQuoteData()
    }

    fun getQuoteData(){
        viewModelScope.launch {
            val response = RandomQuoteApi.retrofitService.getData()
            _quoteStatus.value = response
        }
    }
}