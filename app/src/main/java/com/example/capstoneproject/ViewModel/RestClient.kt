package com.example.capstoneproject.ViewModel

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient{
    private var retrofit: Retrofit? = null
    //Define the base URL
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"
    //Create the retrofit instance to call endpoint and retrieve the list
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}
