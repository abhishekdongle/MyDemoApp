package com.mydemoapp.viewModel

import androidx.lifecycle.MutableLiveData
import com.mydemoapp.model.SplashModel
import com.mydemoapp.base.BaseEvent
import com.mydemoapp.base.BaseViewModel

class SplashViewModel : BaseViewModel() {
    val eventListener: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val modelListener: MutableLiveData<BaseEvent<SplashModel>> by lazy { MutableLiveData<BaseEvent<SplashModel>>() }
}