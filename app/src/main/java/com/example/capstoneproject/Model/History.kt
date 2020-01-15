package com.example.capstoneproject.Model

import java.io.Serializable

class History:Serializable {
    var id: Int? = null
    var date: String = ""
    var point: Float =0.0f
    var category: String? = ""
    constructor(
        id: Int,
        date: String,
        point:Float,
        category: String
    ){
        this.id=id
        this.category=category
        this.point=point
        this.date=date
    }
}