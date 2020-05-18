package com.georgcantor.storetest.model.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("id")
    @Expose
    var id: String?,

    @SerializedName("name")
    @Expose
    var name: String?,

    @SerializedName("img")
    @Expose
    var img: String?
)