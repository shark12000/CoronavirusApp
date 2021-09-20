package com.example.coronaway.utils

sealed class Resource<T>(
    val data: T,
    val error: Throwable? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(throwable: Throwable, data: T) : Resource<T>(data, throwable)
}