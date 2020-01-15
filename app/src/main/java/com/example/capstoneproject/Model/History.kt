package com.example.capstoneproject.Model

import java.io.Serializable

class History:Serializable {
    var date: String = ""
    var grade: Float =0.0f
    var examDto:examDto?=null
    constructor(
        date: String,
        grade:Float,
        examDto: examDto
    ){
        this.grade=grade
        this.date=date
        this.examDto=examDto
    }
}
class examDto:Serializable{
    var id:Int?=null
    var examName:String?=null
    constructor(id:Int,examName:String){
        this.id=id
        this.examName=examName
    }
}