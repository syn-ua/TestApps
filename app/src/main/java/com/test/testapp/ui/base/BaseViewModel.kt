package com.test.testapp.ui.base

import android.content.Context
import android.os.Handler
import android.os.Looper.getMainLooper
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import retrofit2.HttpException

open class BaseViewModel(private val context: Context) : ViewModel() {
    protected val TAG = javaClass.simpleName
    val errors = MutableLiveData<Throwable>()
    val handler = CoroutineExceptionHandler { _, exception ->
        errors.postValue(exception)
        exception.printStackTrace()

        Handler(getMainLooper()).post {
            if (exception is HttpException && exception.response()?.raw()?.request?.url != null) {
                Toast.makeText(context, "Request Url: ${exception.response()?.raw()?.request?.url}\n${exception.message}", LENGTH_LONG).show()
            } else {
                Toast.makeText(context, exception.message, LENGTH_LONG).show()
            }
        }
    }

}