package com.example.capstoneproject.Base

class Singleton private constructor() {
    init {
//        println("This ($this) is a singleton")
    }

    private object Holder {
        val INSTANCE = Singleton()
    }

    companion object {
        val instance: Singleton by lazy { Holder.INSTANCE }
    }

    var token: String? = null
    var userID:Int?=null
}