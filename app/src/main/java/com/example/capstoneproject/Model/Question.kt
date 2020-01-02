package com.example.capstoneproject.Model

open class Question {
    var id: Int? = null
    var content: String = ""
    var categoryID: Int? = null
    var classID: Int? = null
    var difficultID: Int? = null
    var examID: Int? = null

    constructor(
        id: Int,
        content: String,
        categoryID: Int,
        classID: Int,
        difficultID: Int,
        examID: Int
    ){
        this.id = id
        this.content = content
        this.categoryID = categoryID
        this.classID = classID
        this.difficultID = difficultID
        this.examID = examID
    }
}