package com.example.capstoneproject.Model

import java.io.Serializable

open class AnswerUser :Serializable{
    var questionID: Int? = null
    var correctAnswerID: Int? = null
    var answerID: Int? =null
    constructor(){

    }
    constructor(
        questionID: Int,
        answerID:Int,
        correctAnswerID:Int
    ){
        this.answerID=answerID
        this.correctAnswerID=correctAnswerID
        this.questionID=questionID
    }
}