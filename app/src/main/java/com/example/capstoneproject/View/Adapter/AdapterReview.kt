package com.example.capstoneproject.View.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.API.ApiService
import com.example.capstoneproject.API.RestClient
import com.example.capstoneproject.Model.Answer
import com.example.capstoneproject.Model.Category
import com.example.capstoneproject.Model.Question
import com.example.capstoneproject.R
import com.example.capstoneproject.View.Activity.QuizActivity
import com.example.capstoneproject.View.Activity.TestActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdapterReview(private val dataList: List<Question>, private val context: Context,private val llProgressBar: LinearLayout?) :
    RecyclerView.Adapter<AdapterReview.CustomViewHolder>() {
    inner class CustomViewHolder(
        //Get a reference to the Views in our layout
        myView: View
    ) : RecyclerView.ViewHolder(myView) {
        var textQuestion: TextView = myView.findViewById(R.id.questionReview)
        var textAnswer: TextView = myView.findViewById(R.id.answerReview)
        var textExplain: TextView = myView.findViewById(R.id.explainReview)
        var showAnswer: TextView = myView.findViewById(R.id.showAnswer)
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
        holder.textQuestion.text = "Question " + (position + 1) + ": " + dataList[position].content
        val answerCorrect = dataList[position].correctAnswer?.content
        holder.showAnswer.setOnClickListener {
            llProgressBar?.visibility = View.VISIBLE
            val service = RestClient.retrofitInstance!!.create(ApiService::class.java)
            val questionID = dataList[position].id as Int
            var call = service.getAnswerByQuestionID(questionID)
            call.enqueue(object : Callback<List<Answer>> {
                //Handle successfully response
                override
                fun onResponse(call: Call<List<Answer>>, response: Response<List<Answer>>) {
                    if (response.body() != null) {
                        val answerCorrect = response.body() as List<Answer>
                        for (answer in answerCorrect) {
                            if (answer.correct) {
                                holder.textAnswer.visibility = View.VISIBLE
                                holder.textExplain.visibility = View.VISIBLE
                                holder.textAnswer.text = "Answer: " + answer.content
                                holder.textExplain.text = "Explain: " + answer.description
                                break
                            }
                        }

                    }
                    llProgressBar?.visibility = View.GONE
                }
                //Handle failure
                override
                fun onFailure(call: Call<List<Answer>>, throwable: Throwable) {
                    llProgressBar?.visibility = View.GONE
                }
            })
        }

//        holder.textCategory.setOnClickListener{
//            //            Toast.makeText(context, dataList[position].id.toString(), Toast.LENGTH_SHORT).show()
//            var intentQuiz= Intent(context,TestActivity::class.java)
//            intentQuiz.putExtra("idExam", dataList[position].id.toString())
//            context.startActivity(intentQuiz)
//        }
    }
}