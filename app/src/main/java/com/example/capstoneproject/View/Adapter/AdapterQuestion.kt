package com.example.capstoneproject.View.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.Model.Category
import com.example.capstoneproject.R

class AdapterQuestion (private val dataList: List<Category>, private val context: Context):
    RecyclerView.Adapter<AdapterQuestion.CustomViewHolder>() {
    inner class CustomViewHolder(
        //Get a reference to the Views in our layout
        myView: View
    ) : RecyclerView.ViewHolder(myView) {
        var textQuestion: TextView = myView.findViewById(R.id.idQuestion)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.adapter_item_question, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.textQuestion.text =dataList[position].id.toString()
        holder.textQuestion.setOnClickListener{
               Toast.makeText(context, dataList[position].id.toString(), Toast.LENGTH_SHORT).show()

        }
    }
}