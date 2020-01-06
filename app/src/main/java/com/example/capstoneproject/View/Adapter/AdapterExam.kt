package com.example.capstoneproject.View.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.Model.Category
import com.example.capstoneproject.R
import com.example.capstoneproject.View.Activity.QuizActivity
import com.example.capstoneproject.View.Activity.TestActivity

class AdapterExam(private val dataList: List<Category>, private val context: Context):
    RecyclerView.Adapter<AdapterExam.CustomViewHolder>() {
    inner class CustomViewHolder(
        //Get a reference to the Views in our layout
        myView: View
    ) : RecyclerView.ViewHolder(myView) {
        var textCategory: TextView = myView.findViewById(R.id.idExam)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.adapter_exam, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.textCategory.text = dataList[position].id.toString()
        holder.textCategory.setOnClickListener{
//            Toast.makeText(context, dataList[position].id.toString(), Toast.LENGTH_SHORT).show()
            var intentQuiz= Intent(context,TestActivity::class.java)
            intentQuiz.putExtra("idExam", dataList[position].id.toString())
            context.startActivity(intentQuiz)
        }
    }
}