package com.mydemoapp.base

import android.text.TextUtils
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    fun isValid(value: String): Boolean {
        return !(TextUtils.isEmpty(value) || value == null)
    }

}