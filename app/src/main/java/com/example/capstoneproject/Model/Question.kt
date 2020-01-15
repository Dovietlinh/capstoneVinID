package com.example.capstoneproject.Model

import java.io.Serializable

open class Question :Serializable{
    var id: Int? = null
    var content: String = ""
    var description: String =""
    var categoryID: Int? = null
    var classID: Int? = null
    var difficultID: Int? = null
    var examID: Int? = null
    var answerID: Int? =null
    var answerList:List<Answer>?=null
    var correctAnswer:Answer?=null

    constructor(
        id: Int,
        content: String,
        description:String,
        categoryID: Int,
        classID: Int,
        difficultID: Int,
        examID: Int,
        answerID:Int,
        answerList: List<Answer>,
        correctAnswer: Answer
    ){
        this.id = id
        this.content = content
        this.description=description
        this.categoryID = categoryID
        this.classID = classID
        this.difficultID = difficultID
        this.examID = examID
        this.answerID=answerID
        this.answerList=answerList
        this.correctAnswer=correctAnswer
    }
}