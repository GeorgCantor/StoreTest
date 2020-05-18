package com.georgcantor.storetest.view.fragment.company

import android.app.Application
import android.util.MalformedJsonException
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.georgcantor.storetest.MyApplication
import com.georgcantor.storetest.R
import com.georgcantor.storetest.model.data.Company
import com.georgcantor.storetest.repository.ApiRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class CompanyViewModel(
    app: Application,
    private val repository: ApiRepository
) : AndroidViewModel(app) {

    private val context = getApplication<MyApplication>()

    val company = MutableLiveData<Company>()
    val isProgressVisible = MutableLiveData<Boolean>().apply { this.value = true }
    val error = MutableLiveData<String>()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        when (throwable.toString().contains("MalformedJsonException")) {
            true -> error.postValue(context.getString(R.string.json_error_message))
            false -> error.postValue(throwable.message)
        }

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