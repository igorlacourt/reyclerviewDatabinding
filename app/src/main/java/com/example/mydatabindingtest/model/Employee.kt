package com.example.mydatabindingtest.model

import com.google.gson.annotations.SerializedName
import android.R
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide
import androidx.databinding.BindingAdapter



data class Employee(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val first_name: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("last_name")
    val last_name: String
) {

    companion object{
        @BindingAdapter("avatar")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String) {
            Glide.with(view.context)
                .load(imageUrl).apply(RequestOptions().circleCrop())
                .into(view)
        }
    }

//    // important code for loading image here
//    @BindingAdapter("avatar")
//    fun loadImage(imageView: ImageView, imageURL: String) {
//        Glide.with(imageView.getContext())
//            .setDefaultRequestOptions(
//                RequestOptions()
//                    .circleCrop()
//            )
//            .load(imageURL)
//            .into(imageView)
//    }
}