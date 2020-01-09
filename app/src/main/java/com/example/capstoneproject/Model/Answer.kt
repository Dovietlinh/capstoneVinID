package com.example.capstoneproject.Model

open class Answer {
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