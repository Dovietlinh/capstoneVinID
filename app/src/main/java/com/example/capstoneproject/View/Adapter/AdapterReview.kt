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
import com.example.capstoneproject.Model.Question
import com.example.capstoneproject.R
import com.example.capstoneproject.View.Activity.QuizActivity
import com.example.capstoneproject.View.Activity.TestActivity

class AdapterReview(private val dataList: List<Question>, private val context: Context):
    RecyclerView.Adapter<AdapterReview.CustomViewHolder>() {
    inner class CustomViewHolder(
        //Get a reference to the Views in our layout
        myView: View
    ) : RecyclerView.ViewHolder(myView) {
        var textQuestion: TextView = myView.findViewById(R.id.questionReview)
        var textAnswer: TextView = myView.findViewById(R.id.answerReview)
        var textExplain: TextView = myView.findViewById(R.id.explainReview)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.adapter_review, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.textQuestion.text ="Question "+(position+1)+": "+ dataList[position].content
        val listAnswer=dataList[position].listAnswer
        var answer=dataList[position].content
//        listAnswer!!.forEach {
//            if(it.id==dataList[position].id){
//                answer=it.content
//            }
//        }
        holder.textAnswer.text ="Answer: "+ answer
        holder.textExplain.text ="Explain: "+ dataList[position].content
//        holder.textCategory.setOnClickListener{
//            //            Toast.makeText(context, dataList[position].id.toString(), Toast.LENGTH_SHORT).show()
//            var intentQuiz= Intent(context,TestActivity::class.java)
//            intentQuiz.putExtra("idExam", dataList[position].id.toString())
//            context.startActivity(intentQuiz)
//        }
    }
}