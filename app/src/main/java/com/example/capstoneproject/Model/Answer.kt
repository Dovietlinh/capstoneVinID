package com.example.capstoneproject.Model

import java.io.Serializable

open class Answer:Serializable{
    var id: Int? = null
    var content: String = ""
    constructor(
        id: Int,
        content: String
    ){
        this.id = id
        this.content = content
    }
}