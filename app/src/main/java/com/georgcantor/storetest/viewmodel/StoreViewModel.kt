package com.georgcantor.storetest.viewmodel

import androidx.lifecycle.MutableLiveData

class StoreViewModel : BaseViewModel() {

    val fragmentNumbers = MutableLiveData<Int>()

}