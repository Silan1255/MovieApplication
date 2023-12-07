package com.example.movieapplication.utils

import androidx.fragment.app.Fragment
import com.example.movieapplication.data.model.Resource

fun Fragment.handleApiError(
    failure: Resource.Failure,
    customToast: CustomToast
) {
    when (val error = failure.errorBody!!) {
        "no internet connection" -> {
            customToast.show(
                "Please check your internet connection",
                ToastMessageType.ERROR
            )
        }
        else -> {
            customToast.show(error, ToastMessageType.ERROR)
        }
    }
}



