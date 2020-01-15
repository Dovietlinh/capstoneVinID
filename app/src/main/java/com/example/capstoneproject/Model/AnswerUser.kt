package com.example.capstoneproject.Model

import java.io.Serializable

open class AnswerUser :Serializable{
    var questionId: Int? = null
    var correctId: Int = 0
    var answerId: Int =0
    constructor(){

    }
    constructor(
        questionId: Int,
        answerId:Int,
        correctId:Int
    ){
        this.answerId=answerId
        this.correctId=correctId
        this.questionId=questionId
    }
}
open class RequestUser:Serializable{
    var examId:Int? =null
    var point:Float?=null
    var numberPass:Int?=null
    var numberFalse:Int?=null
    var answerByUserList:List<AnswerUser>?=null
    constructor()
    constructor(
        examId:Int,
        point: Float,
        numberPass:Int,
        numberFalse:Int,
        answerByUserList: List<AnswerUser>
    ){
        this.examId=examId
        this.point=point
        this.numberPass=numberPass
        this.numberFalse=numberFalse
        this.answerByUserList=answerByUserList
    }
}