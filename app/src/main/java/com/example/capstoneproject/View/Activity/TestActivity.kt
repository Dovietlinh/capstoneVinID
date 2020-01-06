package com.example.capstoneproject.View.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.capstoneproject.R

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        var idExam: String = intent.getStringExtra("idExam")
        Toast.makeText(this,idExam,Toast.LENGTH_LONG).show()
    }
}
