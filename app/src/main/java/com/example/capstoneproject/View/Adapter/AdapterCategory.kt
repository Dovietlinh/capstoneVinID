package com.example.capstoneproject.View.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.Model.Category
import com.example.capstoneproject.View.Fragment.ListExamFragment

import androidx.appcompat.app.AppCompatActivity


class AdapterCategory(private val dataList: List<Category>,private val context:Context,private val typeTest:Int):
    RecyclerView.Adapter<AdapterCategory.CustomViewHolder>() {
    inner class CustomViewHolder(
        //Get a reference to the Views in our layout
        myView: View
    ) : RecyclerView.ViewHolder(myView) {
        var textCategory: TextView = myView.findViewById(com.example.capstoneproject.R.id.txtCategory)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(com.example.capstoneproject.R.layout.adapter_category, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.textCategory.text = dataList[position].categoryName
        holder.textCategory.setOnClickListener{
            if(typeTest==1){

            }else if(typeTest==2){
                val listExamFragment= ListExamFragment()
                val transaction=(context as AppCompatActivity).supportFragmentManager.beginTransaction()
                transaction.replace(com.example.capstoneproject.R.id.fragment_container, listExamFragment)
                transaction.commit()
            }else if(typeTest==3){

            }
            else{
                Toast.makeText(context, dataList[position].id.toString(), Toast.LENGTH_SHORT).show()
            }

        }
    }
}