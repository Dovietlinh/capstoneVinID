package com.example.capstoneproject.View

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.Model.Category
import com.example.capstoneproject.R
import kotlin.coroutines.coroutineContext

class AdapterCategory(private val dataList: List<Category>,private val context:Context):
    RecyclerView.Adapter<AdapterCategory.CustomViewHolder>() {
    inner class CustomViewHolder(
        //Get a reference to the Views in our layout
        myView: View
    ) : RecyclerView.ViewHolder(myView) {
        var textCategory: TextView = myView.findViewById(R.id.txtCategory)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterCategory.CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.adapter_category, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: AdapterCategory.CustomViewHolder, position: Int) {
        holder.textCategory.text = dataList[position].categoryName
        holder.textCategory.setOnClickListener{
            Toast.makeText(context, dataList[position].id.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}