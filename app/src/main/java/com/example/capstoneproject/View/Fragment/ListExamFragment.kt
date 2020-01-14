package com.example.capstoneproject.View.Fragment

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
    private var llProgressBar: LinearLayout? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.list_exam_fragment,container,false)
        val service = RestClient.retrofitInstance!!.create(ApiService::class.java)
        val categoryID = this.arguments!!.getInt("categoryID")
        val mock = this.arguments!!.getInt("mock")
        var call=service.listExamByCategoryAndMock(categoryID,mock)
        llProgressBar=view.findViewById(R.id.llProgressBar)
        llProgressBar?.visibility = View.VISIBLE
        //Execute the request asynchronously.
        call.enqueue(object : Callback<List<Int>> {
            //Handle successfully response
            override
            fun onResponse(call: Call<List<Int>>, response: Response<List<Int>>) {
                loadDataList(response.body())
                llProgressBar?.visibility = View.GONE
            }
            //Handle failure
            override
            fun onFailure(call: Call<List<Int>>, throwable: Throwable) {

            }
        })

        // Return the fragment view/layout
        return view
    }
    private fun loadDataList(categoryList: List<Int>?) {
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