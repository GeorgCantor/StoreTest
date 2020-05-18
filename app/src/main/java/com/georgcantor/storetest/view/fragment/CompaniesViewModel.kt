package com.georgcantor.storetest.view.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.georgcantor.storetest.model.data.ApiResponse
import com.georgcantor.storetest.repository.ApiRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class CompaniesViewModel(private val repository: ApiRepository) : ViewModel() {

    val companies = MutableLiveData<MutableList<ApiResponse>>()
    val isProgressVisible = MutableLiveData<Boolean>().apply { this.value = true }
    val error = MutableLiveData<String>()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        error.postValue(throwable.message)
        isProgressVisible.postValue(false)
    }

    init {
        viewModelScope.launch(exceptionHandler) {
            val response = repository.getCompanies()
            companies.postValue(response)
        }
    }
}