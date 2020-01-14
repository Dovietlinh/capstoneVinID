package com.example.capstoneproject.Model

import java.io.Serializable

open class Answer:Serializable{
    var id: Int? = null
    var content: String = ""
    var correct: Boolean = false
    var description: String = ""
    constructor(
        id: Int,
        content: String,
        correct: Boolean,
        description: String
    ){
        this.id = id
        this.content = content
        this.correct = correct
        this.description = description
    }
}