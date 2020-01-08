package com.example.capstoneproject.View.Fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.Model.Category
import com.example.capstoneproject.R
import com.example.capstoneproject.View.Adapter.AdapterExam
import com.example.capstoneproject.API.ApiService
import com.example.capstoneproject.API.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListExamFragment :Fragment(){
    private var adapterExam: AdapterExam? = null
    private var myRecyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.list_exam_fragment,container,false)

        val service = RestClient.retrofitInstance!!.create(ApiService::class.java)
        var call=service.allCategory
        //Execute the request asynchronously.
        call.enqueue(object : Callback<List<Category>> {
            //Handle successfully response
            override
            fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                loadDataList(response.body())
            }
            //Handle failure
            override
            fun onFailure(call: Call<List<Category>>, throwable: Throwable) {

            }
        })

        // Return the fragment view/layout
        return view
    }
    private fun loadDataList(categoryList: List<Category>?) {
        myRecyclerView = view?.findViewById(R.id.recyclerListExam)
        adapterExam = AdapterExam(
            categoryList!!,
            requireContext()
        )
        val numberOfCollumn=3

        val layoutManager = GridLayoutManager(context,numberOfCollumn)
        myRecyclerView!!.layoutManager = layoutManager
        myRecyclerView!!.adapter = adapterExam
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