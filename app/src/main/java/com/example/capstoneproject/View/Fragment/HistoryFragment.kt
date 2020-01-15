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
import com.example.capstoneproject.API.ApiService
import com.example.capstoneproject.API.RestClient
import com.example.capstoneproject.Base.Singleton
import com.example.capstoneproject.Model.Category
import com.example.capstoneproject.Model.History
import com.example.capstoneproject.R
import com.example.capstoneproject.View.Adapter.AdapterCategory
import com.example.capstoneproject.View.Adapter.AdapterHistory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryFragment : Fragment() {
    private var adapterHistory: AdapterHistory? = null
    private var myRecyclerView: RecyclerView? = null
    private var llProgressBar: LinearLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.layout_category_fragment,container,false)
        llProgressBar=view.findViewById(R.id.llProgressBar)
        llProgressBar?.visibility = View.VISIBLE
        val userID = this.arguments!!.getInt("userID")
        var singleton = Singleton.instance
        var idUser=singleton.userID as Int
        val service = RestClient.retrofitInstance!!.create(ApiService::class.java)
        var call=service.listAllHistory(idUser)
        //Execute the request asynchronously.
        call.enqueue(object : Callback<List<History>> {
            //Handle successfully response
            override
            fun onResponse(call: Call<List<History>>, response: Response<List<History>>) {
                if(response.body()!=null){
                    loadDataList(response.body())

                }else{
                    Toast.makeText(context,"Bạn chưa có bài thi nào", Toast.LENGTH_LONG).show()
                }
                llProgressBar?.visibility= View.GONE
            }
            //Handle failure
            override
            fun onFailure(call: Call<List<History>>, throwable: Throwable) {
                llProgressBar?.visibility= View.GONE
            }
        })
        // Return the fragment view/layout
        return view
    }

    private fun loadDataList(listHistory: List<History>?) {
        myRecyclerView = view?.findViewById(R.id.recyclerViewCategory)
        adapterHistory = AdapterHistory(
            listHistory!!,
            requireContext()
        )

        val layoutManager = LinearLayoutManager(context)
        myRecyclerView!!.layoutManager = layoutManager
        myRecyclerView!!.adapter = adapterHistory
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