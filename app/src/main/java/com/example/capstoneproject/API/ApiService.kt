package com.example.capstoneproject.API
import com.example.capstoneproject.Model.*
import com.example.capstoneproject.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    //Specify the request type and pass the related URL
    @get:GET("category/getAll")
    // Wrap the response in a Call with the type of the expected result
    val allCategory: Call<List<Category>>

    @GET("category/getQuestion/{id}")
    // Wrap the response in a Call with the type of the expected result
    fun allQuestionByCategory(
        @Path("id") id: Int
    ): Call<List<Question>>

    @GET("question/getByExam/{id}")
    // Wrap the response in a Call with the type of the expected result
    fun allQuestionByExamID(
        @Path("id") id: Int
    ): Call<List<Question>>

    @get:GET("user/getAll")
    // Wrap the response in a Call with the type of the expected result
    val allUser: Call<List<User>>

    @GET("user/detail/{id}")
    fun detailUser(
        @Path("id") id: Int
    ): Call<User>

    @GET("question/getAnswers/{id}")
    fun getAnswerByQuestionID(
        @Path("id") id: Int
    ): Call<List<Answer>>

    @GET("exam/getAllIdExamByCateId/{id}/{mock}")
    fun listExamByCategoryAndMock(
        @Path("id") id: Int,
        @Path("mock") mock: Int
    ): Call<List<Int>>

    @POST("user/login")
    @Headers("Content-Type: application/json")
    fun checkLogin(
        @Body user: User
    ): Call<User>

    @POST("exam/getGrade")
    @Headers("Content-Type: application/json")
    fun getGradeRequest(
        @Body requestUser: RequestUser
    ): Call<RequestUser>

    @POST("user/create")
    @FormUrlEncoded
    fun createUser(@Body user: User): Call<ResponseBody>
}