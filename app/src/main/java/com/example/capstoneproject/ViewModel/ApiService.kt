package com.example.capstoneproject.ViewModel
import com.example.capstoneproject.Model.Category
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    //Specify the request type and pass the related URL
    @get:GET("/users")
    // Wrap the response in a Call with the type of the expected result
    val allCategory: Call<List<Category>>

    @get:GET("/users")
    // Wrap the response in a Call with the type of the expected result
    val allQuestion: Call<List<Category>>
}