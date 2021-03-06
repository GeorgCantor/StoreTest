package com.georgcantor.storetest.util

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.georgcantor.storetest.R

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

fun Context.loadImage(
    url: String,
    view: ImageView
) {
    Glide.with(this)
        .load(url)
        .placeholder(R.drawable.ic_launcher_background)
        .thumbnail(0.1F)
        .into(view)
}