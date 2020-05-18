package com.georgcantor.storetest.util

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun Context.isNetworkAvailable(): Boolean {
    val manager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

    return manager?.activeNetworkInfo?.isConnectedOrConnecting ?: false
}

fun Context.shortToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

inline fun <T> LiveData<T>.observe(
    owner: LifecycleOwner,
    crossinline observer: (T) -> Unit
) {
    this.observe(owner, Observer { it?.apply(observer) })
}