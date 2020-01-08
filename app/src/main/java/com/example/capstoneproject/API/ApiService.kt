package com.example.capstoneproject.API
import android.database.Observable
import com.example.capstoneproject.Model.Category
import com.example.capstoneproject.Model.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    //Specify the request type and pass the related URL
    @get:GET("user/getAll")
    // Wrap the response in a Call with the type of the expected result
    val allCategory: Call<List<Category>>

    @get:GET("user/getAll")
    // Wrap the response in a Call with the type of the expected result
    val allUser: Call<List<User>>

    @GET("user/detail/{id}")
    fun detailUser(
        @Path("id") id: Int
    ): Call<User>

    @POST("user/login")
    @Headers("Content-Type: application/json")
    fun checkLogin(
        @Body user: User
    ): Call<User>

    @POST("user/create")
    @FormUrlEncoded
    fun createUser(@Body user: User): Call<ResponseBody>
}