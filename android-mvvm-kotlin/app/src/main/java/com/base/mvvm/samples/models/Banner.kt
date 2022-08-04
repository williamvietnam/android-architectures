package com.base.mvvm.samples.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Banner(

    @SerializedName("image")
    @Expose
    val image: String,

    @SerializedName("text")
    @Expose
    val text: String

)
