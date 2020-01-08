package com.example.capstoneproject.View.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.capstoneproject.Model.User
import com.example.capstoneproject.R
import com.example.capstoneproject.View.Fragment.CategoryFragment
import com.example.capstoneproject.View.Fragment.HomeFragment
import com.example.capstoneproject.View.Fragment.ProfileFragment
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




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
    fun logout(view:View){
        startActivity(Intent(this@MainActivity,Login::class.java))
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
                val userLogin = intent.getIntExtra("userID",0)
                val b = Bundle()
                b.putInt("userID", userLogin)

                val profileFragment= ProfileFragment()
//                profileFragment.arguments(b)
                val manager=supportFragmentManager
                val transaction=manager.beginTransaction()
                transaction.replace(R.id.fragment_container,profileFragment)
                transaction.addToBackStack(null)
                transaction.commit()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
