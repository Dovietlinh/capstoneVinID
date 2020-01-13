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
open class RequestUser:Serializable{
    var examID:Int? =null
    var point:Float=0.0f
    var numberPass:Int=0
    var numberFail:Int=0
    var listAnswerUser:List<AnswerUser>?=null
    constructor()
    constructor(
        examID:Int,
        point: Float,
        numberPass:Int,
        numberFail:Int,
        listAnswerUser: List<AnswerUser>
    ){
        this.examID=examID
        this.point=point
        this.numberPass=numberPass
        this.numberFail=numberFail
        this.listAnswerUser=listAnswerUser
    }
}