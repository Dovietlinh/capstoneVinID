package com.example.capstoneproject.View.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.Model.Category
import androidx.appcompat.widget.AppCompatImageView
import com.example.capstoneproject.Model.History
import com.example.capstoneproject.R


class AdapterHistory(private val dataList: List<History>,private val context:Context):
    RecyclerView.Adapter<AdapterHistory.CustomViewHolder>() {
    inner class CustomViewHolder(
        //Get a reference to the Views in our layout
        myView: View
    ) : RecyclerView.ViewHolder(myView) {
//        var textCategory: TextView = myView.findViewById(com.example.capstoneproject.R.id.txtCategory)
    }
    var icon:AppCompatImageView?=null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.adapter_history, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
//        holder.textCategory.text = dataList[position].categoryName
//        holder.textCategory.setOnClickListener{
//        }
    }
}