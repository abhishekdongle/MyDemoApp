package com.mydemoapp.base

import androidx.lifecycle.Observer

class EventObserver<T>(private val handlerEvent: (T) -> Unit) : Observer<BaseEvent<T>> {
    override fun onChanged(t: BaseEvent<T>?) {
        t?.getEventHandled()?.let(handlerEvent)
    }
}