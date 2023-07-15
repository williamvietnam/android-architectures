package com.base.mvvm.core.data.network.models.requests

import com.base.mvvm.core.data.network.models.Model
import com.google.gson.annotations.SerializedName

data class ModelRequest(
    @SerializedName("")
    val model: Model
)