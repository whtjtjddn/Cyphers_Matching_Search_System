package com.example.cyphers_matching_search_system.battleitemInfo

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.cyphers_matching_search_system.R

object BindingConversion {

    @BindingAdapter("imageURL")
    @JvmStatic
    fun loadImage(imageView: ImageView, url : String){
        Glide.with(imageView.context).load(url).into(imageView)

    }
}