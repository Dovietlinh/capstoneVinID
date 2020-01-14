package com.example.capstoneproject.View.Fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.API.ApiService
import com.example.capstoneproject.API.RestClient
import com.example.capstoneproject.Model.Question
import com.example.capstoneproject.R
import com.example.capstoneproject.View.Activity.MainActivity
import com.example.capstoneproject.View.Adapter.AdapterReview
import com.example.capstoneproject.View.Dialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewFragment : Fragment(){
    private var adapterReview: AdapterReview? = null
    private var myRecyclerView: RecyclerView? = null
    private var llProgressBar: LinearLayout? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater!!.inflate(R.layout.list_exam_fragment,container,false)
        val service = RestClient.retrofitInstance!!.create(ApiService::class.java)
        val categoryID = this.arguments!!.getInt("categoryID")
        var call=service.allQuestionByCategory(categoryID)
        llProgressBar=view.findViewById(R.id.llProgressBar)
        llProgressBar?.visibility = View.VISIBLE
        var dialog= Dialog()
        //Execute the request asynchronously.
        call.enqueue(object : Callback<List<Question>> {
            //Handle successfully response
            override
            fun onResponse(call: Call<List<Question>>, response: Response<List<Question>>) {
                if(response.body()!=null){
//                    val layout:Int=R.layout.dialog_success
//                    dialog.showCustomDialog(container,context,layout)
//                }else {
                    loadDataList(response.body())
                }
                llProgressBar?.visibility = View.GONE
            }
            //Handle failure
            override
            fun onFailure(call: Call<List<Question>>, throwable: Throwable) {

            }
        })
        return view
    }
    private fun loadDataList(categoryList: List<Question>?){
        myRecyclerView = view?.findViewById(R.id.recyclerListExam)
        adapterReview = AdapterReview(
            categoryList!!,
            requireContext(),llProgressBar
        )
        val layoutManager = LinearLayoutManager(context)
        myRecyclerView!!.layoutManager = layoutManager
        myRecyclerView!!.adapter = adapterReview
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