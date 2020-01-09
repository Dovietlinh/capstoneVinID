package com.example.capstoneproject.Model

open class Question {
    var id: Int? = null
    var content: String = ""
    var description: String =""
    var categoryID: Int? = null
    var classID: Int? = null
    var difficultID: Int? = null
    var examID: Int? = null
    var answerID: Int? =null
    var listAnswer:List<Answer>?=null

    constructor(
        id: Int,
        content: String,
        description:String,
        categoryID: Int,
        classID: Int,
        difficultID: Int,
        examID: Int,
        answerID:Int,
        listAnswer: List<Answer>
    ){
        this.id = id
        this.content = content
        this.description=description
        this.categoryID = categoryID
        this.classID = classID
        this.difficultID = difficultID
        this.examID = examID
        this.answerID=answerID
        this.listAnswer=listAnswer
    }
}