package com.example.movieapplication.data.repository

import com.example.movieapplication.R
import com.example.movieapplication.data.model.Resource
import com.example.movieapplication.ui.currentContext

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {

    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (e: Throwable) {
                when (e) {
                    is HttpException -> {
                        try {
                            try {
                                Resource.Failure(
                                    false,
                                    currentContext.getString(R.string.error_500)
                                )
                            } catch (error: Exception) {
                                Resource.Failure(false, e.message.toString())
                            }
                        } catch (error: Exception) {
                            Resource.Failure(false, e.message.toString())
                        }
                    }
                    else -> Resource.Failure(false, e.message.toString())
                }
            }
        }
    }
}