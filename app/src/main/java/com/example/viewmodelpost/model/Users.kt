package com.example.viewmodelpost.model

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("name")
    var name: String = ""
)