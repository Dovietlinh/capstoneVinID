package com.example.capstoneproject.View.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.capstoneproject.API.ApiService
import com.example.capstoneproject.API.RestClient
import com.example.capstoneproject.Base.Singleton
import com.example.capstoneproject.User
import com.example.capstoneproject.R
import com.example.capstoneproject.View.Fragment.HomeFragment
import com.example.capstoneproject.View.Fragment.ProfileFragment
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Login : AppCompatActivity() {
    var userName: TextView?=null
    var password: TextView?=null
    private var llProgressBar: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }
    fun init(){
        userName= findViewById(R.id.et_username) as TextView
        password = findViewById(R.id.et_password) as TextView
        llProgressBar=findViewById(R.id.llProgressBar)
    }
    fun loginAction(view: View) {
        val user=userName!!.text.toString()
        val pass=password!!.text.toString()
        llProgressBar?.visibility = View.VISIBLE
        var userLogin = User()
        userLogin.password=pass
        userLogin.userName=user
        val service = RestClient.retrofitInstance!!.create(ApiService::class.java)
        var test=service.checkLogin(userLogin)
        var first = Singleton.instance  // This (Singleton@7daf6ecc) is a
        // singleton
        test.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                var userLogin=response.body() as User
                if(userLogin==null){
                    notification_Fail.visibility=View.VISIBLE
                }else{
                    first.token = "hello singleton ok"
                    var intent=Intent(this@Login,MainActivity::class.java)
                    intent.putExtra("userID", userLogin.id)
                    intent.putExtra("token", first.token)
                    startActivity(intent)
                }
                llProgressBar?.visibility = View.GONE
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                notification_Fail.visibility=View.VISIBLE
                llProgressBar?.visibility = View.GONE
            }
        })
    }

}

