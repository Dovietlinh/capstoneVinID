package com.example.capstoneproject.View.Activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.capstoneproject.Base.BaseActivity
import com.example.capstoneproject.R
import com.example.capstoneproject.View.Fragment.HomeFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.bottom_sheet.view.*
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout

import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.API.ApiService
import com.example.capstoneproject.API.RestClient
import com.example.capstoneproject.Model.Category
import com.example.capstoneproject.View.Adapter.AdapterExam
import com.example.capstoneproject.View.Adapter.AdapterQuestion
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TestActivity : BaseActivity(), View.OnClickListener {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    private var adapterQuestion: AdapterQuestion? = null
    private var myRecyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        setSupportActionBar(findViewById(R.id.toolbarExam))
        initView()

        val service = RestClient.retrofitInstance!!.create(ApiService::class.java)
        var call=service.allCategory
        //Execute the request asynchronously.
        call.enqueue(object : Callback<List<Category>> {
            //Handle successfully response
            override
            fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                loadDataList(response.body())
            }
            //Handle failure
            override
            fun onFailure(call: Call<List<Category>>, throwable: Throwable) {

            }
        })
    }
    private fun loadDataList(categoryList: List<Category>?) {
        myRecyclerView = findViewById(R.id.recyclerListQuestion)
        adapterQuestion = AdapterQuestion(
            categoryList!!,
            this@TestActivity
        )
        val numberOfCollumn=6

        val layoutManager = GridLayoutManager(this@TestActivity,numberOfCollumn)
        myRecyclerView!!.layoutManager = layoutManager
        myRecyclerView!!.adapter = adapterQuestion
    }
    private fun initView() {
        coundown(10000)
        buttonBottomSheetDialog.setOnClickListener(this)
        bottomSheetBehavior = BottomSheetBehavior.from<LinearLayout>(bottomSheet)
        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        buttonSlideUp.text = "Slide Up"
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {

                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        buttonSlideUp.text = "Slide Down"
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {

                    }
                    BottomSheetBehavior.STATE_SETTLING -> {

                    }
                }
            }
        })
    }

    override fun onClick(clickView: View?) {
        when (clickView) {
            buttonBottomSheetDialog -> {
                showBottomSheetDialog()
            }
            hidenBottomSheet -> {
                bottomSheetBehavior.isHideable
            }
        }
    }

    private fun showBottomSheetDialog() {
        val view = layoutInflater.inflate(R.layout.bottom_sheet, null)
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(view)
//        view.textViewFacebook.setOnClickListener {
//            dialog.dismiss()
//        }
//        view.textViewTwitter.setOnClickListener {
//            Toast.makeText(this, "Twitter", Toast.LENGTH_SHORT).show()
//        }
//        view.textViewInstagram.setOnClickListener {
//            Toast.makeText(this, "Instagram", Toast.LENGTH_SHORT).show()
//        }
//        view.textViewLinkedin.setOnClickListener {
//            Toast.makeText(this, "Linkedin", Toast.LENGTH_SHORT).show()
//        }
        dialog.show()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.top_bar_exam, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.finish -> {
                val homeFragment= HomeFragment()
                val manager=supportFragmentManager
                val transaction=manager.beginTransaction()
                transaction.replace(R.id.fragment_container,homeFragment)
                transaction.addToBackStack(null)
                transaction.commit()
                return true
            }
            R.id.lamlai->{
                val intent = intent
                finish()
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun coundown(timeCountDown: Long){
        object : CountDownTimer(timeCountDown, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                txtTimer.setText(""+millisUntilFinished / 1000)
            }

            override fun onFinish() {
                txtTimer.setText("Done!")
                showCustomDialog()
            }

        }.start()
    }
    private fun showCustomDialog() {
        //before inflating the custom alert dialog layout, we will get the current activity viewgroup
        val viewGroup = findViewById<ViewGroup>(android.R.id.content)
        //then we will inflate the custom alert dialog xml that we created
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_success, viewGroup, false)
        //Now we need an AlertDialog.Builder object
        val builder = AlertDialog.Builder(this)
        //setting the view of the builder to our custom view that we already inflated
        builder.setView(dialogView)
        //finally creating the alert dialog and displaying it
        val alertDialog = builder.create()
        alertDialog.show()
    }
}
