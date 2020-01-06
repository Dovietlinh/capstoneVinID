package com.example.capstoneproject.View.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.capstoneproject.R
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_login.*


class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var viewPager=findViewById<ViewPager>(R.id.viewPager)
        val pagerAdapter = AuthenticationPagerAdapter(supportFragmentManager)
//        pagerAdapter.addFragmet(LoginFragment())
//        pagerAdapter.addFragmet(RegisterFragment())
        viewPager!!.adapter =pagerAdapter
    }
    internal inner class AuthenticationPagerAdapter(fm: FragmentManager) :
        FragmentPagerAdapter(fm) {
        private val fragmentList = ArrayList<Fragment>()

        override fun getItem(i: Int): Fragment {
            return fragmentList.get(i)
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragmet(fragment: Fragment) {
            fragmentList.add(fragment)
        }
    }
}

