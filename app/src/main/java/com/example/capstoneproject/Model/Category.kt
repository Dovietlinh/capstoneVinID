package com.example.capstoneproject.Model

import com.google.gson.annotations.SerializedName

class Category(
    @SerializedName("id")
    var id: Int?=null,
    @SerializedName("name")
    var categoryName: String?
)