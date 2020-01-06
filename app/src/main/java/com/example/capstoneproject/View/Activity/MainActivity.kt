package com.example.capstoneproject.View.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.capstoneproject.Model.Category
import com.example.capstoneproject.R
import com.example.capstoneproject.View.Fragment.CategoryFragment
import com.example.capstoneproject.View.Fragment.HomeFragment
import com.example.capstoneproject.Model.ApiService
import com.example.capstoneproject.Model.RestClient
import com.example.capstoneproject.Model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        //fragment home
        val homeFragment= HomeFragment()
        val manager=supportFragmentManager
        val transaction=manager.beginTransaction()
        transaction.replace(R.id.fragment_container,homeFragment)
        transaction.addToBackStack(null)
        transaction.commit()

        val service = RestClient.retrofitInstance!!.create(ApiService::class.java)
        var call=service.allUser

        //Execute the request asynchronously.
        call.enqueue(object : Callback<List<User>> {
            //Handle successfully response
            override
            fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
//                Toast.makeText(this@MainActivity, "OK", Toast.LENGTH_SHORT).show()
            }
            //Handle failure
            override
            fun onFailure(call: Call<List<User>>, throwable: Throwable) {
                Toast.makeText(this@MainActivity, "Unable to load users", Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun actionOnThi(view: View) {
        callFragmentAction("onThi")
    }
    fun actionThiThu(view: View) {
        callFragmentAction("thiThu")
    }
    fun actionThiThat(view: View) {
        callFragmentAction("thiThat")
    }
    fun actionLichSu(view: View) {

    }
    fun callFragmentAction(action:String){
        val categoryFragment= CategoryFragment()
        val manager=supportFragmentManager
        val transaction = manager.beginTransaction()
        //
        val bundle = Bundle()
        val action = action
        bundle.putString("action", action)
        categoryFragment.setArguments(bundle)
        // Replace the fragment on container
        transaction.replace(R.id.fragment_container,categoryFragment)
        transaction.addToBackStack(null)
        // Finishing the transition
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.top_bar, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.homeMenu -> {
                val homeFragment= HomeFragment()
                val manager=supportFragmentManager
                val transaction=manager.beginTransaction()
                transaction.replace(R.id.fragment_container,homeFragment)
                transaction.addToBackStack(null)
                transaction.commit()
                return true
            }
            R.id.myProfile -> {
                var intentQuiz= Intent(this,QuizActivity::class.java)
                startActivity(intentQuiz)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
