package com.example.capstoneproject.View.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.capstoneproject.API.ApiService
import com.example.capstoneproject.API.RestClient
import com.example.capstoneproject.Model.User
import com.example.capstoneproject.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_fragment_register.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable


class Login : AppCompatActivity() {
    var userName: TextView?=null
    var password: TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val service = RestClient.retrofitInstance!!.create(ApiService::class.java)
        var test=service.detailUser(1)
        test.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                var test="ok"
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                var tt = t
            }
        })
        init()
    }
    fun init(){
        userName= findViewById(R.id.et_username) as TextView
        password = findViewById(R.id.et_password) as TextView
    }
    fun loginAction(view: View) {
        val user=userName!!.text.toString()
        val pass=password!!.text.toString()

        var userLogin = User()
        userLogin.password=pass
        userLogin.userName=user

        val service = RestClient.retrofitInstance!!.create(ApiService::class.java)
        var test=service.checkLogin(userLogin)
        test.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                var userLogin=response.body() as User
                if(userLogin==null){
                    notification_Fail.visibility=View.VISIBLE
                }else{
                    var intent=Intent(this@Login,MainActivity::class.java)
                    intent.putExtra("userID", userLogin.id)
                    startActivity(intent)
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                notification_Fail.visibility=View.VISIBLE
            }
        })
    }

}

