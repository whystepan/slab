package com.example.smartlab

import com.google.gson.annotations.SerializedName

data class NewsClass(
    @SerializedName("id")
    val newsid: Int,

    @SerializedName("name")
    val newsname: String,

    @SerializedName("description")
    val newsdesc: String,

    @SerializedName("price")
    val newsprice: Float,

    @SerializedName("img_url")
    val newsimg: String
    )
