package com.example.capstoneproject.View.Adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.Model.Category
import com.example.capstoneproject.View.Fragment.ListExamFragment

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.example.capstoneproject.R
import com.example.capstoneproject.View.Fragment.ReviewFragment


class AdapterCategory(private val dataList: List<Category>,private val context:Context,private val typeTest:Int,private val userID:Int):
    RecyclerView.Adapter<AdapterCategory.CustomViewHolder>() {
    inner class CustomViewHolder(
        //Get a reference to the Views in our layout
        myView: View
    ) : RecyclerView.ViewHolder(myView) {
        var textCategory: TextView = myView.findViewById(com.example.capstoneproject.R.id.txtCategory)
    }
    var icon:AppCompatImageView?=null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.adapter_category, parent, false)
        icon=view.findViewById(R.id.iconListCategory)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        if(position%3==2){
            icon?.setBackgroundResource(R.mipmap.ic_launcher)
        }
        else if(position%3==1){
            icon?.setBackgroundResource(R.mipmap.book)
        }
        holder.textCategory.text = dataList[position].categoryName
        var categoryID=dataList[position].id as Int
        holder.textCategory.setOnClickListener{
            if(typeTest==1){
                val reviewFragment=ReviewFragment()
                val b = Bundle()
                b.putInt("categoryID", categoryID)
                reviewFragment.setArguments(b)
                val transaction=(context as AppCompatActivity).supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container,reviewFragment)
                transaction.commit()
            }else if(typeTest==2){
                val listExamFragment= ListExamFragment()
                val b = Bundle()
                b.putInt("categoryID",categoryID )
                b.putInt("userID",userID )
                b.putInt("mock",1)
                listExamFragment.setArguments(b)
                val transaction=(context as AppCompatActivity).supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, listExamFragment)
                transaction.commit()
            }else if(typeTest==3){
                val listExamFragment= ListExamFragment()
                val b = Bundle()
                b.putInt("categoryID",categoryID )
                b.putInt("userID",userID )
                b.putInt("mock",0)
                listExamFragment.setArguments(b)
                val transaction=(context as AppCompatActivity).supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, listExamFragment)
                transaction.commit()
            }
            else{
                Toast.makeText(context, dataList[position].id.toString(), Toast.LENGTH_SHORT).show()
            }

        }
    }
}