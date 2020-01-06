package com.example.capstoneproject.Model

import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("id")
    var id: Int? = null

    @SerializedName("fullName")
    var fullName: String? = null

    @SerializedName("email")
    var email: String? = null

    @SerializedName("phone")
    var phone: String? = null

    @SerializedName("role")
    var role: String? = null

    @SerializedName("active")
    var active: Boolean? = null
}