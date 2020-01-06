package com.example.capstoneproject.Model
import android.database.Observable
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    //Specify the request type and pass the related URL
    @get:GET("user/getAll")
    // Wrap the response in a Call with the type of the expected result
    val allCategory: Call<List<Category>>

    @get:GET("user/getAll")
    // Wrap the response in a Call with the type of the expected result
    val allUser: Call<List<User>>

    @POST("/studentLoginUsingPOST")
    @FormUrlEncoded
    fun checkLogin(
        @Field("userName") userName: String,
        @Field("passWorld") password: String
    ): Observable<User>

    @POST("/createUserUsingPOST")
    @FormUrlEncoded
    fun createUser(
        @Field("fullName") fullName: String,
        @Field("phone") phone: String,
        @Field("email") email: String,
        @Field("userName") userName: String,
        @Field("passWorld") password: String
    ): Observable<User>

}