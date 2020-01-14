package com.example.capstoneproject.View

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import com.example.capstoneproject.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity
import com.example.capstoneproject.Model.RequestUser
import com.example.capstoneproject.View.Activity.MainActivity
import com.example.capstoneproject.View.Activity.TestActivity
import com.example.capstoneproject.View.Fragment.ListExamFragment


open class Dialog {
    constructor()
    fun showBottomSheetDialog(context : Context) {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.bottom_sheet, null)
        val dialog = BottomSheetDialog(context)
        dialog.setContentView(view)
        dialog.show()
    }
    fun showCustomDialog(viewGroup: ViewGroup?,context: Context?,layout: Int,requestUser: RequestUser) {
        //before inflating the custom alert dialog layout, we will get the current activity viewgroup
//        val viewGroup = activity.findViewById<ViewGroup>(android.R.id.content)

        //then we will inflate the custom alert dialog xml that we created

        val dialogView = LayoutInflater.from(context).inflate(layout, viewGroup, false)
        //Now we need an AlertDialog.Builder object
        val builder = AlertDialog.Builder(context as Context)
        //setting the view of the builder to our custom view that we already inflated
        builder.setView(dialogView)
        //finally creating the alert dialog and displaying it
        val alertDialog = builder.create()
        alertDialog.show()

        val replayExam = dialogView .findViewById(R.id.replayExam) as Button
        val finish = dialogView .findViewById(R.id.btnFinish) as Button
        val point = dialogView .findViewById(R.id.txtPoint) as TextView
        val numberPass = dialogView .findViewById(R.id.txtPass) as TextView
        val numberFail = dialogView .findViewById(R.id.txtfail) as TextView
        point.text=requestUser.point.toString()+ " POINT"
        numberPass.text=requestUser.numberPass.toString()
        numberFail.text=requestUser.numberFalse.toString()

        finish.setOnClickListener {
            var gotoMain = Intent(context, MainActivity::class.java)
            context.startActivity(gotoMain)
            alertDialog.dismiss()

        }
        replayExam.setOnClickListener{
            alertDialog.dismiss()

        }
    }
}