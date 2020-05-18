package com.georgcantor.storetest.view.fragment.company

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.georgcantor.storetest.model.data.Company
import com.georgcantor.storetest.repository.ApiRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class CompanyViewModel(private val repository: ApiRepository) : ViewModel() {

    val company = MutableLiveData<Company>()
    val isProgressVisible = MutableLiveData<Boolean>().apply { this.value = true }
    val error = MutableLiveData<String>()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        error.postValue(throwable.message)
        isProgressVisible.postValue(false)
    }

    fun getCompany(id: String) {
        viewModelScope.launch(exceptionHandler) {
            val response = repository.getCompany(id)
            company.postValue(response[0])
            isProgressVisible.postValue(false)
        }
    }
}