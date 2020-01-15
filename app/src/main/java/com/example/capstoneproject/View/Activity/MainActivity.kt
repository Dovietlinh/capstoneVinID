package com.example.capstoneproject.View.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import com.example.capstoneproject.R
import com.example.capstoneproject.View.Fragment.CategoryFragment
import com.example.capstoneproject.View.Fragment.HistoryFragment
import com.example.capstoneproject.View.Fragment.HomeFragment
import com.example.capstoneproject.View.Fragment.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*


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
        callFragmentActionHistory()
    }
    fun logout(view:View){
        startActivity(Intent(this@MainActivity,Login::class.java))
    }
    fun callFragmentAction(action:String){
        val categoryFragment= CategoryFragment()
        val manager=supportFragmentManager
        val transaction = manager.beginTransaction()
        val userLogin = intent.getIntExtra("userID",0)
        val bundle = Bundle()
        val action = action
        bundle.putString("action", action)
        bundle.putInt("userID", userLogin)
        categoryFragment.setArguments(bundle)
        // Replace the fragment on container
        transaction.replace(R.id.fragment_container,categoryFragment)
        transaction.addToBackStack(null)
        // Finishing the transition
        transaction.commit()
    }
    fun callFragmentActionHistory(){
        val historyFragment= HistoryFragment()
        val manager=supportFragmentManager
        val transaction = manager.beginTransaction()
        val userLogin = intent.getIntExtra("userID",0)
        val bundle = Bundle()
        bundle.putInt("userID", userLogin)
        historyFragment.setArguments(bundle)
        // Replace the fragment on container
        transaction.replace(R.id.fragment_container,historyFragment)
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
                profileFragment.setArguments(b)
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
