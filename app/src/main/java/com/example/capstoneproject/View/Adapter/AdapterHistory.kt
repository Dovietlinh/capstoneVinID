package com.example.capstoneproject.View.Adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
        var textCategory: TextView = myView.findViewById(R.id.txtCategory)
        var txtDate: TextView = myView.findViewById(R.id.txtDate)
        var txtPoint: TextView = myView.findViewById(R.id.txtPoint)
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
        val index=(position+1)
        
        holder.textCategory.text =index.toString()+". "+ dataList[position].examDto?.examName
//        holder.txtDate.text = dataList[position].date
        var checkPass=" PASS"
        if(dataList[position].grade>=0.5){
            holder.txtPoint.setTextColor(Color.GREEN)
        }else{
            holder.txtPoint.setTextColor(Color.RED)
            checkPass =" FAILED"
        }
        val poi=dataList[position].grade.times(10)
        holder.txtPoint.text = poi.toString()+checkPass
    }
}