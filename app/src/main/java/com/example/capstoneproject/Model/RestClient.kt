package com.example.capstoneproject.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient{
    private var retrofit: Retrofit? = null
    //Define the base URL
//    private const val BASE_URL = "https://jsonplaceholder.typicode.com"

    private const val BASE_URL = "https://vinschoolexam.herokuapp.com/api/"
    //Create the retrofit instance to call endpoint and retrieve the list
    val retrofitInstance: Retrofit?
        get() {
            try{
                if (retrofit == null) {
                    retrofit = retrofit2.Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return retrofit
            }catch (e: Exception){
                return null
            }

        }
}
