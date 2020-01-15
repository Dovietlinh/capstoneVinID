package com.example.capstoneproject.View.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.API.ApiService
import com.example.capstoneproject.API.RestClient
import com.example.capstoneproject.Model.Question
import com.example.capstoneproject.R
import com.example.capstoneproject.View.Activity.TestActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable

class AdapterExam(private val dataList: List<Int>, private val context: Context, private val userID: Int) :
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
        holder.textCategory.text = "Exam " + (position+1)
        holder.textCategory.setOnClickListener {

            val service = RestClient.retrofitInstance!!.create(ApiService::class.java)
            val idExam=dataList[position] as Int
            var call = service.allQuestionByExamID(idExam)
//            var call = service.allQuestionByCategory(dataList[position])
            //Execute the request asynchronously.
            call.enqueue(object : Callback<List<Question>> {
                //Handle successfully response
                override
                fun onResponse(call: Call<List<Question>>, response: Response<List<Question>>) {
                    if(response.body()!=null && response.body()?.size!=0){
                        var intentQuiz = Intent(context, TestActivity::class.java)
                        intentQuiz.putExtra("idExam", dataList[position])
                        intentQuiz.putExtra("userID", userID)
                        val listQuestion=response.body() as List<Question>
                        intentQuiz.putExtra("listQuestion",listQuestion as Serializable)
                        context.startActivity(intentQuiz)
                    }else{
                        Toast.makeText(context,"Không có câu hỏi nào trong đề",Toast.LENGTH_LONG).show()
                    }
                }
                //Handle failure
                override
                fun onFailure(call: Call<List<Question>>, throwable: Throwable) {

                }
            })

        }
    }
}