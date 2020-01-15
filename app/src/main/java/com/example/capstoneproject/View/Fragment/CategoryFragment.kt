package com.example.capstoneproject.View.Fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.Model.Category
import com.example.capstoneproject.R
import com.example.capstoneproject.View.Adapter.AdapterCategory
import com.example.capstoneproject.API.ApiService
import com.example.capstoneproject.API.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class CategoryFragment: Fragment() {
    private var adapterCategory: AdapterCategory? = null
    private var myRecyclerView: RecyclerView? = null
    private var llProgressBar: LinearLayout? = null
    private var typeTest:Int=0
    private var userID:Int=0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val valueAction = this.arguments!!.getString("action")
        userID = this.arguments!!.getInt("userID")
        val view = inflater!!.inflate(R.layout.layout_category_fragment,container,false)
        llProgressBar=view.findViewById(R.id.llProgressBar)
        llProgressBar?.visibility = View.VISIBLE
        val service = RestClient.retrofitInstance!!.create(ApiService::class.java)
        var call=service.allCategory
        if(valueAction.equals("onThi")){
            typeTest=1
        }else if(valueAction.equals("thiThu")){
            typeTest=2
        }else if(valueAction.equals("thiThat")){
            typeTest=3
        }else{
            typeTest=4
        }
        //Execute the request asynchronously.
        call.enqueue(object : Callback<List<Category>> {
            //Handle successfully response
            override
            fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                if(response.body()!=null){
                    loadDataList(response.body())

                }else{
                    Toast.makeText(context,"Không có môn học nào",Toast.LENGTH_LONG).show()
                }
                llProgressBar?.visibility=View.GONE
            }
            //Handle failure
            override
            fun onFailure(call: Call<List<Category>>, throwable: Throwable) {
                llProgressBar?.visibility=View.GONE
            }
        })

        // Return the fragment view/layout
        return view
    }

    private fun loadDataList(categoryList: List<Category>?) {
        myRecyclerView = view?.findViewById(R.id.recyclerViewCategory)
        adapterCategory = AdapterCategory(
            categoryList!!,
            requireContext(),typeTest,userID
        )

        val layoutManager = LinearLayoutManager(context)
        myRecyclerView!!.layoutManager = layoutManager
        myRecyclerView!!.adapter = adapterCategory
    }
    override fun onPause() {
        super.onPause()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }
}