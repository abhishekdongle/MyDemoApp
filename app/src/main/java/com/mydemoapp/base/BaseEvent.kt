package com.mydemoapp.base

open class BaseEvent<out T>(private val event: T) {
    var isHandled = false
        private set

    fun getEventHandled(): T? {
        return if (isHandled) {
            null
        } else {
            isHandled = true
            event
        }
    }

    fun peekEvent(): T = event
}