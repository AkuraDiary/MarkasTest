package com.asthiseta.core.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.asthiseta.core.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("avatar")
fun avatar(imageView: ImageView, avatar: String) =
    Glide.with(imageView)
        .load(avatar)
        .apply(RequestOptions.circleCropTransform()).placeholder(R.drawable.ic_user)
        .into(imageView)